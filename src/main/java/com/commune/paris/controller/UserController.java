package com.commune.paris.controller;

import com.commune.paris.entity.PUser;
import com.commune.paris.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user",name = "博主管理")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;
    @RequestMapping(value = "/getOne/{id}",method = RequestMethod.GET,name = "根据id获取博主信息")
    public PUser getOne(@PathVariable("id") Integer id){
        PUser user = userService.getOne(id);
        return user;
    }
}