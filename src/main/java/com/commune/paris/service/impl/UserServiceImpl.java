package com.commune.paris.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.commune.paris.dto.UserDTO;
import com.commune.paris.entity.PUser;
import com.commune.paris.entity.PUserExample;
import com.commune.paris.mapper.PUserMapper;
import com.commune.paris.service.IUserService;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private PUserMapper userMapper;

    @Override
    public PUser getOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PUser getByname(String username) {
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
        List<PUser> blogs = userMapper.getUserByPage(query,pageQuery);
        List<UserDTO> userDTOS = blogs.stream().map(user -> {
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
        int i = userMapper.insertSelective(user);
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

    private UserDTO getUserDO(PUser user){
        if (user==null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        userDTO.setStatus(getInteger(user.getStatus()));
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
