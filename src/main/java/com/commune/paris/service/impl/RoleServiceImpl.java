package com.commune.paris.service.impl;

import com.commune.paris.dto.RoleDTO;
import com.commune.paris.entity.PPermission;
import com.commune.paris.entity.PRole;
import com.commune.paris.entity.PRolePermission;
import com.commune.paris.entity.PRolePermissionExample;
import com.commune.paris.mapper.PRoleMapper;
import com.commune.paris.mapper.PRolePermissionMapper;
import com.commune.paris.service.IPermissionService;
import com.commune.paris.service.IRoleService;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public ReturnData<RoleDTO> getListByPage(String query, PageQuery pageQuery) {
        ReturnData<RoleDTO> roleDTOReturnData = new ReturnData<>();
        Integer count = roleMapper.countAll(query);
        List<PRole> pRoles = roleMapper.getRoleByPage(query,pageQuery);
        List<RoleDTO> roleDTOS = pRoles.stream().map(role -> {
            RoleDTO roleDTO = getRoleDO(role);
            return roleDTO;
        }).collect(Collectors.toList());
        roleDTOReturnData.setTotal(count);
        roleDTOReturnData.setData(roleDTOS);
        roleDTOReturnData.setPageNo(pageQuery.getPageNo());
        roleDTOReturnData.setPageSize(pageQuery.getPageSize());
        return roleDTOReturnData;
    }

    @Override
    public PRole getById(Integer id) {
        PRole role = roleMapper.selectByPrimaryKey(id);
        return role;
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
            roleDTO.setPermissions(permissions);
        }
        return roleDTO;
    }

}
