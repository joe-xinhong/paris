package com.commune.paris.service.impl;

import com.commune.paris.entity.PUser;
import com.commune.paris.mapper.PUserMapper;
import com.commune.paris.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private PUserMapper userMapper;

    @Override
    public PUser getOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
