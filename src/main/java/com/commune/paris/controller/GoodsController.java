package com.commune.paris.controller;

import com.commune.paris.dto.GoodsDTO;
import com.commune.paris.entity.PGoods;
import com.commune.paris.model.GoodsModel;
import com.commune.paris.service.IGoodsService;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/goods",name = "商品管理接口")
@Slf4j
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;

    @RequestMapping(value = "/save",method = RequestMethod.POST,name = "新增商品接口")
    public Result save(@Validated @RequestBody GoodsModel goodsModel){
        Result result = goodsService.saveBy(goodsModel);
        return result;
    }

    @RequestMapping(value = "/goodList",method = RequestMethod.GET,name = "按条件分页查询商品列表接口")
    public Result goodList(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam Integer pageSize, @RequestParam(required = false) String query){
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNo(pageNo);
        if (pageSize!=null){
            pageQuery.setPageSize(pageSize);
        }
        ReturnData<GoodsDTO> goodsList = goodsService.getListByPage(query,pageQuery);
        return Result.success(goodsList);
    }

    @RequestMapping(value = "/updateGoods/{id}",method = RequestMethod.PUT,name = "修改商品信息接口")
    public Result updateGoods(@PathVariable("id") Integer id, @RequestBody GoodsModel goodsModel){
        if (goodsModel==null){
            return Result.fail("无修改信息");
        }
        goodsModel.setId(id);
        Result result = goodsService.updateBy(goodsModel);
        return result;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE,name = "删除商品接口")
    public Result delete(@PathVariable("id") Integer id){
        Result result = goodsService.deleteBy(id);
        return result;
    }

    @RequestMapping(value = "/getOne/{id}",method = RequestMethod.GET,name = "根据id查询商品详情接口")
    public Result getOne(@PathVariable("id") Integer id){
        Result result = goodsService.getOneById(id);
        return Result.success(result);
    }
}

