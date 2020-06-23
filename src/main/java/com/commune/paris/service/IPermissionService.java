package com.commune.paris.service;

import com.commune.paris.entity.PPermission;
import com.commune.paris.utils.Result;

import java.util.List;


public interface IPermissionService {
    Result findAllMenu();

    Result findAllList();

    PPermission getById(Integer id);

    List<PPermission> getByParentId(Integer id);
}
