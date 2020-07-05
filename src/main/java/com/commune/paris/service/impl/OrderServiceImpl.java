package com.commune.paris.service.impl;

import com.commune.paris.dto.DataDTO;
import com.commune.paris.dto.OrderDTO;
import com.commune.paris.dto.OrderDetailDTO;
import com.commune.paris.entity.*;
import com.commune.paris.mapper.*;
import com.commune.paris.model.OrderModel;
import com.commune.paris.service.IOrderService;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private POrderMapper orderMapper;
    @Autowired
    private PLogisticsMapper logisticsMapper;
    @Autowired
    private PGoodsMapper goodsMapper;
    @Autowired
    private PUserMapper userMapper;
    @Autowired
    private POrderDetailMapper detailMapper;
    @Autowired
    private PCategoryMapper categoryMapper;

    @Override
    @Transactional
    public Result saveOrder(OrderModel orderModel) {
        if (orderModel==null || orderModel.getOrderId()!=null || orderModel.getId()!=null || orderModel.getOrderDetails().isEmpty()){
            return Result.fail("信息有误");
        }
        //1.生成订单号
        String orderId = get();
        orderModel.setOrderId(orderId);

        POrder byOrderId = getOrderByOrderId(orderId);
        if (byOrderId!=null){
            return Result.fail("信息有误");
        }

        //2.查询商品信息/增加订单详情
        orderModel.getOrderDetails().forEach(orderDetail ->{
            PGoods pGoods = goodsMapper.selectByPrimaryKey(orderDetail.getGoodsId());
            if (pGoods!=null){
                orderDetail.setOrderId(orderId);
                orderDetail.setCateId(pGoods.getCateId());
                orderDetail.setPayPrice(pGoods.getPrice() * orderDetail.getGoodsCount());
                detailMapper.insert(orderDetail);
            }
        });
        //3.增加物流信息
        PLogistics pLogistics = new PLogistics();
        pLogistics.setCreateTime(new Date());
        pLogistics.setOrderId(orderId);
        pLogistics.setTitle("已经申请，待发货");
        logisticsMapper.insert(pLogistics);

        //4.加入订单信息
        POrder pOrder = new POrder();
        BeanUtils.copyProperties(orderModel,pOrder);
        pOrder.setCreateTime(new Date());
        pOrder.setUpdateTime(new Date());
        pOrder.setPayStatue(1);
        pOrder.setSendStatus(0);
        orderMapper.insert(pOrder);
        return Result.success(pOrder);
    }

    @Override
    @Transactional
    public ReturnData<OrderDTO> getOrderByPage(POrder pOrder, PageQuery pageQuery) {
        ReturnData<OrderDTO> orderReturnData = new ReturnData<>();
        Integer count = orderMapper.countOrderAll(pOrder.getUserId());
        List<POrder> orderList = orderMapper.getOrderByPage(pOrder.getUserId(),pageQuery);
        if (!orderList.isEmpty()){
            List<OrderDTO> orderDTOS = orderList.stream().map(order -> {
                OrderDTO orderDTO = new OrderDTO();
                BeanUtils.copyProperties(order, orderDTO);
                PUser pUser = userMapper.selectByPrimaryKey(order.getUserId());
                if (pUser != null) {
                    orderDTO.setUserName(pUser.getUsername());
                }
                List<OrderDetailDTO> details = getDetailById(order.getOrderId());
                orderDTO.setDetailDTOS(details);
                return orderDTO;
            }).collect(Collectors.toList());
            orderReturnData.setTotal(count);
            orderReturnData.setData(orderDTOS);
            orderReturnData.setPageNo(pageQuery.getPageNo());
            orderReturnData.setPageSize(pageQuery.getPageSize());
        }
        return orderReturnData;
    }

    @Override
    public Result updateOrderBy(POrder pOrder) {
        if (pOrder==null||pOrder.getId()==null||pOrder.getOrderId()==null){
            return Result.fail("信息有误");
        }
        orderMapper.updateByPrimaryKeySelective(pOrder);
        return Result.success(null);
    }

    @Override
    @Transactional
    public Result deleteById(String orderId) {
        POrderExample example = new POrderExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<POrder> orderList = orderMapper.selectByExample(example);
        if (orderList.isEmpty()){
            return Result.fail("信息有误");
        }
        //删除订单物流信息
        List<PLogistics> logistics = getLogisticsByOrderId(orderId);
        if (!logistics.isEmpty()){
            logisticsMapper.deleteByOrderId(orderId);
        }
        //删除订单详情
        POrderDetailExample detailExample = new POrderDetailExample();
        detailExample.createCriteria().andOrderIdEqualTo(orderId);
        List<POrderDetail> details = detailMapper.selectByExample(detailExample);
        if (!details.isEmpty()){
            detailMapper.deleteByOrderId(orderId);
        }
        //删除订单
        orderMapper.deleteByOrderId(orderId);
        return Result.success(null);
    }

    @Override
    public Result getOneById(String orderId) {
        POrder byOrderId = getOrderByOrderId(orderId);
        return Result.success(byOrderId);
    }

    @Override
    public Result getLogistics(String orderId) {
        List<PLogistics> logistics = getLogisticsByOrderId(orderId);
        return Result.success(logistics);
    }

    @Override
    @Transactional
    public Result UpdateState(Integer id, Integer status) {
        POrder order = orderMapper.selectByPrimaryKey(id);
        if (order==null){
            return Result.fail("信息有误");
        }
        POrder pOrder = new POrder();
        pOrder.setId(id);
        pOrder.setSendStatus(status);
        orderMapper.updateByPrimaryKeySelective(pOrder);

        //添加物流信息
        PLogistics logistics = new PLogistics();
        logistics.setCreateTime(new Date());
        if (status == 1){
            logistics.setTitle("已发货");
        }else if (status == 2){
            logistics.setTitle("已收货");
        }else {
            logistics.setTitle("交易结束");
        }
        logistics.setOrderId(order.getOrderId());
        logisticsMapper.insert(logistics);

        return Result.success(null);
    }

    @Override
    public Result getCount() {
        List<PUser> users = userMapper.selectByExample(new PUserExample());
        if (users.isEmpty()){
            return Result.success(null);
        }
        List<String> nameList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        users.forEach(user -> {
            Integer count = orderMapper.countOrderAll(user.getId());
            if (count>0){
                countList.add(count);
                nameList.add(user.getUsername());
            }
        });
        DataDTO dataDTO = new DataDTO();
        dataDTO.setCountList(countList);
        dataDTO.setNameList(nameList);
        return Result.success(dataDTO);
    }

    @Override
    public List<POrder> getListByToday() {
        List<POrder> today = orderMapper.getToday();
        return today;
    }

    @Override
    public List<POrder> getListByMonth() {
        List<POrder> month = orderMapper.getMonth();
        return month;
    }

    @Override
    public List<POrder> getListAll() {
        List<POrder> orders = orderMapper.selectByExample(new POrderExample());
        return orders;
    }

    @Override
    public Result getGoodsCount() {
        List<PGoods> goodsList = goodsMapper.selectByExample(new PGoodsExample());
        if (goodsList.isEmpty()){
            return Result.success(null);
        }
        List<String> nameList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        goodsList.forEach(goods->{
            Integer count = detailMapper.countGoodsAll(goods.getId());
            if (count>0){
                nameList.add(goods.getName());
                countList.add(count);
            }
        });
        DataDTO dataDTO = new DataDTO();
        dataDTO.setCountList(countList);
        dataDTO.setNameList(nameList);
        return Result.success(dataDTO);
    }

    /**
     * 判断该订单号是否已经存在
     * @param orderId
     * @return
     */
    private POrder getOrderByOrderId(String orderId){
        POrderExample example = new POrderExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<POrder> orders = orderMapper.selectByExample(example);
        if (orders.isEmpty()){
            return null;
        }
        return orders.get(0);
    }

    /**
     * 订单号获取
     * @return
     */
    private static String get(){
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    /**
     * 根据订单号获取全部物流信息
     * @param orderId
     * @return
     */
    private List<PLogistics> getLogisticsByOrderId(String orderId){
        PLogisticsExample example = new PLogisticsExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        example.setOrderByClause("create_time desc");
        List<PLogistics> logistics = logisticsMapper.selectByExample(example);
        return logistics;
    }

    /**
     * 根据订单号获取全部详情信息
     * @return
     */
    private List<OrderDetailDTO> getDetailById(String orderId){
        POrderDetailExample example = new POrderDetailExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<POrderDetail> details = detailMapper.selectByExample(example);
        if (details.isEmpty()){
            return null;
        }
        List<OrderDetailDTO> detailDTOS = details.stream().map(detail -> {
            OrderDetailDTO detailDTO = new OrderDetailDTO();
            BeanUtils.copyProperties(detail, detailDTO);
            PGoods pGoods = goodsMapper.selectByPrimaryKey(detail.getGoodsId());
            if (pGoods != null) {
                detailDTO.setGoodsName(pGoods.getName());
                detailDTO.setSmallImg(pGoods.getSmallImg());
            }
            PCategory category = categoryMapper.selectByPrimaryKey(detail.getCateId());
            if (category != null) {
                detailDTO.setCateName(category.getName());
            }
            return detailDTO;
        }).collect(Collectors.toList());
        return detailDTOS;

    }

}
