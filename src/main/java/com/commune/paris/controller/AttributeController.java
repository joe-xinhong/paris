package com.commune.paris.controller;

import com.commune.paris.entity.PAttribute;
import com.commune.paris.entity.PAttributeValue;
import com.commune.paris.service.IAttributeService;
import com.commune.paris.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/attribute",name = "参数/属性管理接口")
@Slf4j
public class AttributeController {

    @Autowired
    private IAttributeService attributeService;

    @RequestMapping(value = "/getList/{cate_id}",method = RequestMethod.GET,name = "根据分类id与参数类别获取静态/动态属性")
    public Result getList(@PathVariable("cate_id")Integer cate_id, @RequestParam(value = "sel") String sel){
        Result result = attributeService.getList(cate_id, sel);
        return result;
    }

    @RequestMapping(value = "/save/{cate_id}",method = RequestMethod.POST,name = "添加商品参数接口")
    public Result save(@PathVariable("cate_id")Integer cate_id, @Validated @RequestBody PAttribute attribute){
        if (attribute==null||attribute.getId()!=null|| cate_id==null){
            return Result.fail("信息有误");
        }
        attribute.setCateId(cate_id);
        Result result = attributeService.save(attribute);
        return Result.success(result);
    }

    @RequestMapping(value = "/getOne/{cate_id}/{id}",method = RequestMethod.GET,name = "根据分类id与参数类别获取静态/动态属性")
    public Result getOne(@PathVariable("cate_id")Integer cate_id, @PathVariable("id")Integer id, @RequestParam(value = "sel") String sel){
        Result result = attributeService.getOne(cate_id, id, sel);
        return result;
    }
    @RequestMapping(value = "/UpdateOne/{cate_id}/{id}",method = RequestMethod.PUT,name = "修改参数")
    public Result UpdateOne(@PathVariable("cate_id")Integer cate_id, @PathVariable("id")Integer id, @Validated @RequestBody PAttribute attribute){
        if (attribute==null){
            return Result.fail("信息有误");
        }
        attribute.setCateId(cate_id);
        attribute.setId(id);
        Result result = attributeService.UpdateOne(attribute);
        return result;
    }
    @RequestMapping(value = "/delete/{cate_id}/{id}",method = RequestMethod.DELETE,name = "删除参数")
    public Result delete(@PathVariable("cate_id")Integer cate_id, @PathVariable("id")Integer id){
        Result result = attributeService.delete(cate_id,id);
        return result;
    }

    @RequestMapping(value = "/saveValue/{id}",method = RequestMethod.PUT,name = "添加商品参数对应值接口")
    public Result saveValue(@PathVariable("id")Integer id, @Validated @RequestBody PAttributeValue attributeValue){
        if (attributeValue==null||attributeValue.getId()!=null){
            return Result.fail("信息有误");
        }
        attributeValue.setAttributeId(id);
        Result result = attributeService.saveValue(attributeValue);
        return Result.success(result);
    }
    @RequestMapping(value = "/deleteValue/{id}",method = RequestMethod.PUT,name = "删除商品参数对应值接口")
    public Result deleteValue(@PathVariable("id")Integer id, @Validated @RequestBody PAttributeValue attributeValue){
        if (attributeValue==null||attributeValue.getId()==null){
            return Result.fail("信息有误");
        }
        attributeValue.setAttributeId(id);
        Result result = attributeService.deleteValue(attributeValue);
        return Result.success(result);
    }
}
