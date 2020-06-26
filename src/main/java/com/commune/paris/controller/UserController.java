package com.commune.paris.controller;

import com.commune.paris.dto.UserDTO;
import com.commune.paris.entity.PUser;
import com.commune.paris.service.IUserService;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user",name = "博主管理接口")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @RequiresAuthentication
    @RequestMapping(value = "/getOne/{id}",method = RequestMethod.GET,name = "根据id获取博主信息接口")
    public Result getOne(@PathVariable("id") Integer id){
        PUser user = userService.getOne(id);
        return Result.success(user);
    }

    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET,name = "根据id获取用户信息接口")
    public Result getUser(@PathVariable("id") Integer id){
        Result result = userService.getUserById(id);
        return result;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,name = "新增博主接口")
    public Result save(@Validated @RequestBody PUser user){
        PUser save = userService.save(user);
        return Result.success(save);
    }
    @RequestMapping(value = "/users",method = RequestMethod.GET,name = "按条件分页查询用户列表接口")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage,@RequestParam Integer pageSize,@RequestParam(required = false) String query){
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNo(currentPage);
        if (pageSize!=null){
            pageQuery.setPageSize(pageSize);
        }
        ReturnData<UserDTO> userList = userService.getListByPage(query,pageQuery);
        return Result.success(userList);
    }
    @RequestMapping(value = "/{id}/state/{status}",method = RequestMethod.PUT,name = "修改用户状态接口")
    public Result updateState(@PathVariable("id")Integer id,@PathVariable("status")Boolean status){
        Result result = userService.UpdateState(id,status);
        return result;
    }
    @RequestMapping(value = "/updateUser/{id}",method = RequestMethod.PUT,name = "修改用户信息接口")
    public Result updateUser(@PathVariable("id") Integer id, @RequestBody PUser user){
        if (user==null){
            return Result.fail("无修改信息");
        }
        user.setId(id);
        Result result = userService.updateUser(user);
        return result;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE,name = "删除用户接口")
    public Result delete(@PathVariable("id") Integer id){
        Result result = userService.deleteById(id);
        return result;
    }

    @RequestMapping(value = "/updateRole/{id}/{rId}",method = RequestMethod.PUT,name = "分配用户角色接口")
    public Result updateRole(@PathVariable("id") Integer id, @PathVariable("rId") Integer rId){
        Result result = userService.updateRole(id,rId);
        return result;
    }

}
