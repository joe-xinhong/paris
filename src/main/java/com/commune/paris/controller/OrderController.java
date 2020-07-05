package com.commune.paris.controller;

import com.commune.paris.dto.DataDTO;
import com.commune.paris.dto.IndexTableDTO;
import com.commune.paris.dto.OrderDTO;
import com.commune.paris.entity.POrder;
import com.commune.paris.model.OrderModel;
import com.commune.paris.service.IOrderService;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/order",name = "订单管理接口")
@Slf4j
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/orders",method = RequestMethod.GET,name = "按条件分页查询订单列表接口")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam Integer pageSize, @RequestParam(required = false) Integer userId){
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNo(currentPage);
        if (pageSize!=null){
            pageQuery.setPageSize(pageSize);
        }
        POrder pOrder = new POrder();
        if (userId!=null){
            pOrder.setUserId(userId);
        }
        ReturnData<OrderDTO> userList = orderService.getOrderByPage(pOrder,pageQuery);
        return Result.success(userList);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,name = "新增订单接口")
    public Result save(@Validated @RequestBody OrderModel orderModel){
        Result result = orderService.saveOrder(orderModel);
        return result;
    }

    @RequestMapping(value = "/updateOrder/{id}",method = RequestMethod.PUT,name = "修改订单部分信息接口")
    public Result updateOrder(@PathVariable("id") Integer id, @RequestBody POrder pOrder){
        pOrder.setId(id);
        Result result = orderService.updateOrderBy(pOrder);
        return result;
    }

    @RequestMapping(value = "/{id}/send/{status}",method = RequestMethod.PUT,name = "修改订单发货状态接口")
    public Result updateState(@PathVariable("id")Integer id,@PathVariable("status")Integer status){
        Result result = orderService.UpdateState(id,status);
        return result;
    }

    @RequestMapping(value = "/getLogistics/{orderId}",method = RequestMethod.GET,name = "获取订单物流信息接口")
    public Result updateState(@PathVariable("orderId")String orderId){
        Result result = orderService.getLogistics(orderId);
        return result;
    }

    @RequestMapping(value = "/delete/{orderId}",method = RequestMethod.DELETE,name = "删除订单接口")
    public Result delete(@PathVariable("orderId") String orderId){
        Result result = orderService.deleteById(orderId);
        return result;
    }

    @RequestMapping(value = "/getCount",method = RequestMethod.GET,name = "获取订单统计接口")
    public Result getCount(){
        Result result = orderService.getCount();
        return result;
    }

}

