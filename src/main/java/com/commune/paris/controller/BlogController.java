package com.commune.paris.controller;

import com.commune.paris.entity.PBlog;
import com.commune.paris.service.IBlogService;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
* @Description:    博文接口
* @Author:         Joe
* @CreateDate:     2020/6/6 16:57
*/
@RestController
@Slf4j
@RequestMapping(value = "/blog",name = "/博文管理")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @RequestMapping(value = "/list",method = RequestMethod.GET,name = "分页查询博文列表")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNo(currentPage);
        List<PBlog> pBlogList = blogService.getListByPage(pageQuery);
        return Result.success(pBlogList);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,name = "根据id查询博文详情")
    public Result detail(@PathVariable("id") Integer id){
        PBlog blog = blogService.getOneById(id);
        Assert.notNull(blog,"该博文已经被删除");
        return Result.success(blog);
    }

    @RequiresAuthentication
    @RequestMapping(value = "/edit",method = RequestMethod.POST,name = "新增/编辑博文")
    public Result edit(@Validated @RequestBody PBlog blog){
        PBlog temp;
        if (blog.getId() != null){
            //编辑
            temp = blogService.getOneById(blog.getId());
            Assert.isTrue(temp.getUserId()==ShiroUtil.getProfile().getId(),"没有权限编辑");

        }else {
            //新增
            temp = new PBlog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(new Date());
            temp.setStatus(0);
        }

        BeanUtils.copyProperties(blog,temp,"id","userId","created","status");
        Integer bId = blogService.saveOrUpdate(temp);
        return Result.success(null);
    }
}
