package com.commune.paris.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.commune.paris.dto.LoginDTO;
import com.commune.paris.entity.PUser;
import com.commune.paris.service.IUserService;
import com.commune.paris.utils.JwtUtils;
import com.commune.paris.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
@RequestMapping(value = "/paris",name = "/博文主业务")
public class AccountController {
    @Autowired
    IUserService userService;
    @Autowired
    JwtUtils jwtUtils;

    @RequestMapping(value = "/login",method = RequestMethod.POST,name = "登录")
    public Result login(@Validated @RequestBody LoginDTO loginDTO, HttpServletResponse response){
        PUser user = userService.getByname(loginDTO.getUsername());
        Assert.notNull(user,"用户不存在");
        log.info("输入的明码:{}",loginDTO.getPassword());
        log.info("密码加密后:{}",SecureUtil.md5(loginDTO.getPassword()));
        log.info("用户密码:{}",user.getPassword());
        if (!user.getPassword().equals(SecureUtil.md5(loginDTO.getPassword()))){
            return Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        log.info("登录生成的jwt:{}",jwt);
        response.setHeader("Authorization",jwt);
        response.setHeader("Access-control-Expose-Headers","Authorization");
        return Result.success(MapUtil.builder()
        .put("id",user.getId())
        .put("username",user.getUsername())
        .put("email",user.getEmail()).map());
    }

    @RequiresAuthentication
    @RequestMapping(value = "/logout",method = RequestMethod.GET,name = "退出登录")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.success(null);
    }
}
