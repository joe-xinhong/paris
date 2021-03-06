package com.commune.paris.service;

import com.commune.paris.dto.UserDTO;
import com.commune.paris.entity.PUser;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;

public interface IUserService {

    Result getUserById(Integer id);

    PUser getOne(Integer id);

    PUser getByName(String username);

    ReturnData<UserDTO> getListByPage(String query, PageQuery pageQuery);

    PUser save(PUser user);

    Result UpdateState(Integer id, Boolean status);

    Result updateUser(PUser pUser);

    Result deleteById(Integer id);

    Result updateRole(Integer id, Integer rId);

    Result getAll();
}
