package com.commune.paris.model;

import com.commune.paris.entity.POrderDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrderModel {
    /**
     * id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 0：未支付；1：已支付
     */
    private Integer payStatue;

    /**
     * 0：未发货；1：已发货；
     */
    private Integer sendStatus;

    /**
     * 个人/公司
     */
    private String billTitle;

    /**
     * 公司名称
     */
    private String billCompany;

    /**
     * 发票内容
     */
    private String billContent;

    private String address;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 订单详情集合
     */
    private List<POrderDetail> orderDetails = new ArrayList<>();
}
