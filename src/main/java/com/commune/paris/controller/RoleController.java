package com.commune.paris.controller;

import com.commune.paris.dto.RoleDTO;
import com.commune.paris.service.IRoleService;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/role",name = "角色管理接口")
@Slf4j
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @RequestMapping(value = "/roles",method = RequestMethod.GET,name = "按条件分页查询角色列表接口")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam Integer pageSize, @RequestParam String query){
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNo(currentPage);
        if (pageSize!=null){
            pageQuery.setPageSize(pageSize);
        }
        ReturnData<RoleDTO> roleList = roleService.getListByPage(query,pageQuery);
        return Result.success(roleList);
    }
}
