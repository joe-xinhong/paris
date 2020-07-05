package com.commune.paris.dto;

import com.commune.paris.entity.PLogistics;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    /**
     * id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 用户名称
     */
    private String userName;

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
     * 物流
     */
    private List<PLogistics> logistics = new ArrayList<>();
    /**
     * 详情
     */
    private List<OrderDetailDTO> detailDTOS = new ArrayList<>();

}
