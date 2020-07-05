package com.commune.paris.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 商品所属分类名称
     */
    private String cateName;

    private String smallImg;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 支付商品数量
     */
    private Integer goodsCount;

    /**
     * 需要支付金额
     */
    private Double payPrice;
}
