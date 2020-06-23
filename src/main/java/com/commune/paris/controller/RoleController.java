package com.commune.paris.controller;

import com.commune.paris.dto.RoleDTO;
import com.commune.paris.entity.PRole;
import com.commune.paris.service.IRoleService;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/role",name = "角色管理接口")
@Slf4j
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/roles",method = RequestMethod.GET,name = "分页查询角色列表接口")
    public Result list(){
        Result result = roleService.getListByList();
        return Result.success(result);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,name = "新增角色接口")
    public Result save(@Validated @RequestBody PRole role){
        PRole save = roleService.save(role);
        return Result.success(save);
    }

    @RequestMapping(value = "/getRole/{id}",method = RequestMethod.GET,name = "根据id获取角色信息接口")
    public Result getRole(@PathVariable("id") Integer id){
        Result result = roleService.getRoleById(id);
        return result;
    }

    @RequestMapping(value = "/updateRole/{id}",method = RequestMethod.PUT,name = "修改角色信息接口")
    public Result updateRole(@PathVariable("id") Integer id, @RequestBody PRole role){
        if (role==null){
            return Result.fail("无修改信息");
        }
        role.setId(id);
        Result result = roleService.updateRole(role);
        return result;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE,name = "删除角色信息接口")
    public Result delete(@PathVariable("id") Integer id){
        Result result = roleService.deleteById(id);
        return result;
    }

    @RequestMapping(value = "/{id}/permission/{pId}",method = RequestMethod.PUT,name = "删除角色的权限接口")
    public Result deletePermission(@PathVariable("id")Integer id,@PathVariable("pId")Integer pId){
        Result result = roleService.deletePermission(id,pId);
        return result;
    }

    @RequestMapping(value = "/updatePermission/{id}",method = RequestMethod.PUT,name = "分配角色权限接口")
    public Result updatePermission(@PathVariable("id") Integer id, @RequestParam String ids){
        if (ids==null||ids.length()<1){
            return Result.fail("信息有误");
        }
        Result result = roleService.updatePermission(id,ids);
        return result;
    }
}
