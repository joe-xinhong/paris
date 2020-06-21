package com.commune.paris.controller;

import com.commune.paris.service.IPermissionService;
import com.commune.paris.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/permission",name = "权限接口")
@Slf4j
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping(value = "/getAllMenu",name = "获取全部菜单接口",method = RequestMethod.GET)
    public Result getAllMenu(){
        Result result = permissionService.findAllMenu();
        return result;
    }

    @RequestMapping(value = "/getAllList",name = "获取全部菜单列表接口",method = RequestMethod.GET)
    public Result getAllList(){
        Result result = permissionService.findAllList();
        return result;
    }
}
