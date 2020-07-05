package com.commune.paris.model;

import com.commune.paris.dto.AttributeDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class GoodsModel {
    /**
     * 商品id
     */
    private Integer id;

    /**
     * 所属分类id
     */
    private Integer cateId;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 动态参数集合
     */
    private List<AttributeDTO> manies = new ArrayList<>();
    /**
     * 静态参数集合
     */
    private List<AttributeDTO> onlys = new ArrayList<>();

}
