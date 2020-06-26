package com.commune.paris.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.commune.paris.dto.UserDTO;
import com.commune.paris.entity.*;
import com.commune.paris.mapper.PRoleUserMapper;
import com.commune.paris.mapper.PUserMapper;
import com.commune.paris.service.IRoleService;
import com.commune.paris.service.IUserService;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private PUserMapper userMapper;
    @Autowired
    private PRoleUserMapper roleUserMapper;
    @Autowired
    private IRoleService roleService;

    @Override
    public Result getUserById(Integer id) {
        PUser user = userMapper.selectByPrimaryKey(id);
        UserDTO userDTO = getUserDO(user);
        return Result.success(userDTO);
    }

    @Override
    public PUser getOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PUser getByName(String username) {
        PUserExample example = new PUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<PUser> pUsers = userMapper.selectByExample(example);
        if (pUsers!=null&&pUsers.size()>0){
            return pUsers.get(0);
        }
        return null;
    }

    @Override
    public ReturnData<UserDTO> getListByPage(String query,PageQuery pageQuery) {
        ReturnData<UserDTO> userReturnData = new ReturnData<>();
        Integer count = userMapper.countAll(query);
        List<PUser> pUsers = userMapper.getUserByPage(query,pageQuery);
        List<UserDTO> userDTOS = pUsers.stream().map(user -> {
            UserDTO userDTO = getUserDO(user);
            return userDTO;
        }).collect(Collectors.toList());
        userReturnData.setTotal(count);
        userReturnData.setData(userDTOS);
        userReturnData.setPageNo(pageQuery.getPageNo());
        userReturnData.setPageSize(pageQuery.getPageSize());
        return userReturnData;
    }

    @Override
    public PUser save(PUser user) {
        if (user==null){
            return null;
        }
        String s = SecureUtil.md5(user.getPassword());
        user.setPassword(s);
        user.setLastLogin(new Date());
        user.setCreated(new Date());
        user.setStatus(1);
        userMapper.insertSelective(user);
        return user;
    }

    @Override
    public Result UpdateState(Integer id, Boolean status) {
        PUser user = userMapper.selectByPrimaryKey(id);
        if (user==null){
            return Result.fail("信息有误");
        }
        PUser pUser = new PUser();
        if (status){
            pUser.setStatus(1);
        }else {
            pUser.setStatus(0);
        }
        pUser.setId(user.getId());
        int i = userMapper.updateByPrimaryKeySelective(pUser);
        return Result.success(i);
    }

    @Override
    public Result updateUser(PUser pUser) {
        if (pUser==null||pUser.getId()==null){
            return Result.fail("信息有误");
        }
        PUser pUser1 = userMapper.selectByPrimaryKey(pUser.getId());
        if (pUser1==null){
            return Result.fail("用户信息不存在");
        }
        int i = userMapper.updateByPrimaryKeySelective(pUser);
        return Result.success(i);
    }

    @Override
    @Transactional
    public Result deleteById(Integer id) {
        PUser pUser1 = userMapper.selectByPrimaryKey(id);
        if (pUser1==null){
            return Result.fail("用户信息不存在");
        }
        PRoleUserExample example = new PRoleUserExample();
        example.createCriteria().andUserIdEqualTo(id);
        List<PRoleUser> roleUsers = roleUserMapper.selectByExample(example);
        if (!roleUsers.isEmpty()){
            roleUserMapper.deleteByUserId(id);
        }
        int i = userMapper.deleteByPrimaryKey(id);
        return Result.success(i);
    }

    @Override
    @Transactional
    public Result updateRole(Integer id, Integer rId) {
        PUser pUser = userMapper.selectByPrimaryKey(id);
        if (pUser==null){
            return Result.fail("用户信息有误");
        }
        PRole role = roleService.getById(rId);
        if (role == null){
            return Result.fail("角色信息有误");
        }
        PRoleUserExample example = new PRoleUserExample();
        example.createCriteria().andUserIdEqualTo(id);
        List<PRoleUser> roleUsers = roleUserMapper.selectByExample(example);
        if (!roleUsers.isEmpty()){
            roleUserMapper.deleteByUserId(id);
        }
        PRoleUser roleUser = new PRoleUser();
        roleUser.setUserId(id);
        roleUser.setRoleId(rId);
        int i = roleUserMapper.insert(roleUser);
        return Result.success(i);
    }

    private UserDTO getUserDO(PUser user){
        if (user==null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        PRoleUserExample example = new PRoleUserExample();
        example.createCriteria().andUserIdEqualTo(user.getId());
        List<PRoleUser> roleUsers = roleUserMapper.selectByExample(example);
        BeanUtils.copyProperties(user,userDTO);
        userDTO.setStatus(getInteger(user.getStatus()));
        if (!roleUsers.isEmpty()){
            List<PRole> roles = roleUsers.stream().map(roleUser -> {
                PRole role = roleService.getById(roleUser.getRoleId());
                return role;
            }).collect(Collectors.toList());
            userDTO.setRoles(roles);
        }
        return userDTO;
    }

    private boolean getInteger(Integer status){
        if (status==null || status==1){
            return true;
        }else {
            return false;
        }
    }
}
