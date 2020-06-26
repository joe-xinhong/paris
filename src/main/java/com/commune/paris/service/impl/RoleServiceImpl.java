package com.commune.paris.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.commune.paris.dto.RoleDTO;
import com.commune.paris.entity.*;
import com.commune.paris.mapper.PRoleMapper;
import com.commune.paris.mapper.PRolePermissionMapper;
import com.commune.paris.mapper.PRoleUserMapper;
import com.commune.paris.service.IPermissionService;
import com.commune.paris.service.IRoleService;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.TreeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private PRoleMapper roleMapper;
    @Autowired
    private PRolePermissionMapper rolePermissionMapper;
    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private PRoleUserMapper roleUserMapper;

    @Override
    public Result getListByList() {
        PRoleExample example = new PRoleExample();
        List<PRole> pRoles = roleMapper.selectByExample(example);
        List<RoleDTO> roleDTOS = pRoles.stream().map(role -> {
            RoleDTO roleDTO = getRoleDO(role);
            return roleDTO;
        }).collect(Collectors.toList());
        return Result.success(roleDTOS);
    }

    @Override
    public PRole getById(Integer id) {
        PRole role = roleMapper.selectByPrimaryKey(id);
        return role;
    }

    @Override
    public PRole save(PRole role) {
        if (getRoleByName(role.getName())){
            role.setCreateTime(new Date());
            role.setUpdateTime(new Date());
            roleMapper.insertSelective(role);
            return role;
        }
        return null;
    }

    @Override
    public Result getRoleById(Integer id) {
        PRole role = roleMapper.selectByPrimaryKey(id);
        return Result.success(role);
    }

    @Override
    public Result updateRole(PRole role) {
        if (role==null || role.getId()==null||role.getName()!=null){
            return Result.fail("信息有误");
        }
        PRole pRole = roleMapper.selectByPrimaryKey(role.getId());
        if (pRole==null){
            return Result.fail("角色信息不存在");
        }
        role.setUpdateTime(new Date());
        int i = roleMapper.updateByPrimaryKeySelective(role);
        return Result.success(i);
    }

    @Override
    @Transactional
    public Result deleteById(Integer id) {
        //1.查询角色对应的信息
        PRole role = roleMapper.selectByPrimaryKey(id);
        if (role==null){
            return Result.fail("信息有误");
        }
        //2.用户角色表删除对应信息
        PRoleUserExample roleUserExample = new PRoleUserExample();
        roleUserExample.createCriteria().andRoleIdEqualTo(role.getId());
        List<PRoleUser> roleUsers = roleUserMapper.selectByExample(roleUserExample);
        if (!roleUsers.isEmpty()){
            roleUserMapper.deleteByRoleId(id);
        }

        //3.角色权限表删除对应信息
        PRolePermissionExample rolePermissionExample = new PRolePermissionExample();
        rolePermissionExample.createCriteria().andRoleIdEqualTo(role.getId());
        List<PRolePermission> rolePermissions = rolePermissionMapper.selectByExample(rolePermissionExample);
        if (!rolePermissions.isEmpty()){
            rolePermissionMapper.deleteByRoleId(role.getId());
        }
        int i = roleMapper.deleteByPrimaryKey(id);
        return Result.success(i);
    }

    @Override
    @Transactional
    public Result deletePermission(Integer id, Integer pId) {
        //分别查询该角色及权限存在。且有关联
        PRole role = roleMapper.selectByPrimaryKey(id);
        if (role==null){
            Result.fail("信息不存在");
        }
        //删除该角色对应的权限（是否存在下级权限并删除）
        List<Integer> ids = new ArrayList<>();

        ids.add(pId);

        List<PPermission> permissions = permissionService.getByParentId(pId);
        if (!permissions.isEmpty()){
            permissions.forEach(pPermission -> {
                ids.add(pPermission.getId());
            });
        }
        if (ids!=null&& ids.size()>0){
            for (int i = 0; i < ids.size(); i++) {
                PRolePermission rolePermission=new PRolePermission();
                rolePermission.setRoleId(id);
                rolePermission.setPermissionId(ids.get(i));
                rolePermissionMapper.delete(rolePermission);
            }
        }
        //获取该角色的最新数据并返回
        RoleDTO roleDTO = getRoleDO(role);
        return Result.success(roleDTO.getChild());
    }

    @Override
    @Transactional
    public Result updatePermission(Integer id, String ids) {
        //判断角色是否存在并删除当前对应的所有权限
        PRole role = roleMapper.selectByPrimaryKey(id);
        if (role==null){
            return Result.fail("信息有误");
        }
        PRolePermissionExample rolePermissionExample = new PRolePermissionExample();
        rolePermissionExample.createCriteria().andRoleIdEqualTo(role.getId());
        List<PRolePermission> rolePermissions = rolePermissionMapper.selectByExample(rolePermissionExample);
        if (!rolePermissions.isEmpty()){
            rolePermissionMapper.deleteByRoleId(id);
        }
        //将最新的权限添加到关联表
        String[] strings = ids.split(",");
        if (strings!=null&&strings.length>0){
            for (int i = 0; i < strings.length; i++) {
                PRolePermission rolePermission = new PRolePermission();
                rolePermission.setPermissionId(Integer.parseInt(strings[i]));
                rolePermission.setRoleId(id);
                rolePermissionMapper.insert(rolePermission);
            }
            return Result.success(null);
        }else {
            return Result.fail("信息有误");
        }
    }

    /**
     * 判断角色名称是否重复
     * @param name
     * @return
     */
    private boolean getRoleByName(String name){
        PRoleExample example = new PRoleExample();
        example.createCriteria().andNameEqualTo(name);
        List<PRole> roles = roleMapper.selectByExample(example);
        if(!roles.isEmpty()){
            return false;
        }
        return true;
    }

    private RoleDTO getRoleDO(PRole role){
        if (role == null){
            return null;
        }
        RoleDTO roleDTO = new RoleDTO();

        PRolePermissionExample example = new PRolePermissionExample();
        example.createCriteria().andRoleIdEqualTo(role.getId());
        List<PRolePermission> rolePermissionList = rolePermissionMapper.selectByExample(example);

        BeanUtils.copyProperties(role,roleDTO);

        if (!rolePermissionList.isEmpty()){
            List<PPermission> permissions = rolePermissionList.stream().map(rolePermission -> {
                PPermission pPermission = permissionService.getById(rolePermission.getPermissionId());
                return pPermission;
            }).collect(Collectors.toList());
            JSONArray array = new JSONArray();
            TreeUtils.setPermissionsTree(0,permissions,array);
            roleDTO.setChild(array);
        }
        return roleDTO;
    }

}
