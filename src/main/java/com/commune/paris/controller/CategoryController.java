package com.commune.paris.controller;

import com.commune.paris.entity.PCategory;
import com.commune.paris.service.ICategoryService;
import com.commune.paris.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category",name = "商品分类接口")
@Slf4j
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    /**
     * 获取所有分类接口
     * @param type 1：只获取一级分类；2：获取一二级所有分类；3/null：所有分类
     * @return
     */
    @RequestMapping(value = "/getList",name = "获取所有分类接口",method = RequestMethod.GET)
    public Result getList(@RequestParam Integer type){
        Result result = categoryService.findAllList(type);
        return result;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,name = "添加商品分类接口")
    public Result save(@Validated @RequestBody PCategory category){
        if (category==null||category.getId()!=null){
            return Result.fail("信息有误");
        }
        Result result = categoryService.save(category);
        return Result.success(result);
    }

    @RequestMapping(value = "/updateCate/{id}",method = RequestMethod.PUT,name = "修改商品分类信息接口")
    public Result updateCate(@PathVariable("id") Integer id, PCategory category){
        if (category==null){
            return Result.fail("无修改信息");
        }
        category.setId(id);
        Result result = categoryService.update(category);
        return result;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE,name = "删除商品分类接口")
    public Result delete(@PathVariable("id") Integer id){
        Result result = categoryService.deleteById(id);
        return result;
    }

}
