package com.commune.paris.service;

import com.commune.paris.dto.OrderDTO;
import com.commune.paris.entity.POrder;
import com.commune.paris.model.OrderModel;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;

import java.util.List;

public interface IOrderService {

    Result saveOrder(OrderModel orderModel);

    ReturnData<OrderDTO> getOrderByPage(POrder pOrder, PageQuery pageQuery);

    Result updateOrderBy(POrder pOrder);

    Result deleteById(String orderId);

    Result getOneById(String orderId);

    Result getLogistics(String orderId);

    Result UpdateState(Integer id, Integer status);

    Result getCount();

    /**
     * 当天数据
     * @return
     */
    List<POrder> getListByToday();

    /**
     * 当月数据
     * @return
     */
    List<POrder> getListByMonth();

    List<POrder> getListAll();

    Result getGoodsCount();
}
