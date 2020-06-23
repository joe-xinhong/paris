package com.commune.paris.service;

import com.commune.paris.entity.PRole;
import com.commune.paris.utils.Result;

public interface IRoleService {
    Result getListByList();

    PRole getById(Integer id);

    PRole save(PRole role);

    Result getRoleById(Integer id);

    Result updateRole(PRole role);

    Result deleteById(Integer id);

    Result deletePermission(Integer id, Integer pId);

    Result updatePermission(Integer id, String ids);
}
