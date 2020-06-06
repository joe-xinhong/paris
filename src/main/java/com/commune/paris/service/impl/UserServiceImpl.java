package com.commune.paris.service.impl;

import com.commune.paris.entity.PUser;
import com.commune.paris.entity.PUserExample;
import com.commune.paris.mapper.PUserMapper;
import com.commune.paris.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
