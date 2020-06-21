package com.commune.paris.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.commune.paris.entity.PPermission;
import com.commune.paris.entity.PPermissionExample;
import com.commune.paris.mapper.PPermissionMapper;
import com.commune.paris.service.IPermissionService;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.TreeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PPermissionMapper permissionMapper;

    @Override
    public Result findAllMenu() {
        List<PPermission> permissions = getAll(1);
        JSONArray array = new JSONArray();
        TreeUtils.setPermissionsTree(0,permissions,array);
        return Result.success(array);
    }

    @Override
    public Result findAllList() {
        List<PPermission> permissions = getAll(1);
        return Result.success(permissions);
    }

    @Override
    public PPermission getById(Integer id) {
        PPermission pPermission = permissionMapper.selectByPrimaryKey(id);
        return pPermission;
    }

    /**
     * 根据类型获取不同权限集合
     * @param type=1菜单；type=2 接口
     * @return
     */
    private List<PPermission> getAll(Integer type){
        PPermissionExample pExample = new PPermissionExample();
        pExample.createCriteria().andTypeEqualTo(type);
        List<PPermission> permissions = permissionMapper.selectByExample(pExample);
        return permissions;
    }
}
