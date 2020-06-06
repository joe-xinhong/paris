package com.commune.paris.service;

import com.commune.paris.entity.PUser;

public interface IUserService {
    PUser getOne(Integer id);

    PUser getByname(String username);
}
