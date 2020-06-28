package com.commune.paris.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class GoodsDTO {
    /**
     * 商品id
     */
    private Integer id;

    /**
     * 所属分类id
     */
    private String cateName;

    /**
     * 商品名称
     */
    @NotNull(message = "商品名称不能为空")
    private String name;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品主图
     */
    private String bigImg;

    /**
     * 商品缩略图
     */
    private String smallImg;

    /**
     * 商品状态
     */
    private Integer state;

    /**
     * 价格
     */
    private Double price;

    /**
     * 库存量
     */
    private Integer stock;

    /**
     * 上线时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;
}
