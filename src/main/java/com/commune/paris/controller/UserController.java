package com.commune.paris.controller;

import com.commune.paris.entity.PUser;
import com.commune.paris.service.IUserService;
import com.commune.paris.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user",name = "博主管理")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @RequiresAuthentication
    @RequestMapping(value = "/getOne/{id}",method = RequestMethod.GET,name = "根据id获取博主信息")
    public Result getOne(@PathVariable("id") Integer id){
        PUser user = userService.getOne(id);
        return Result.success(user);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,name = "新增博主")
    public Result save(@Validated @RequestBody PUser user){
        return Result.success(user);
    }
}
