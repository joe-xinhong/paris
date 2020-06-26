package com.commune.paris.model;

import com.commune.paris.entity.PAttributeValue;
import lombok.Data;


@Data
public class AttributeModel {

    /**
     * 参数id
     */
    private Integer id;

    /**
     * 参数名称
     */
    private String name;

    /**
     * 所属分类id
     */
    private Integer cateId;

    /**
     * only:静态属性；many:动态参数
     */
    private String sel;

    /**
     * manual:手工录入；list:列表选择
     */
    private String write;
    /**
     * 属性值输入
     */
    private String val;
}
