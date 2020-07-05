package com.commune.paris.controller;

import com.commune.paris.service.IChinaService;
import com.commune.paris.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/china",name = "行政单位地区接口")
@Slf4j
public class ChinaController {

    @Autowired
    private IChinaService chinaService;

    @RequestMapping(value = "/getAllTree",name = "获取全部行政地区接口",method = RequestMethod.GET)
    public Result getAllTree(){
        Result result = chinaService.getAllTree();
        return result;
    }
}
