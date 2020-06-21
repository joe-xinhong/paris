package com.commune.paris.service;

import com.commune.paris.dto.RoleDTO;
import com.commune.paris.entity.PRole;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.ReturnData;

public interface IRoleService {
    ReturnData<RoleDTO> getListByPage(String query, PageQuery pageQuery);

    PRole getById(Integer id);
}
