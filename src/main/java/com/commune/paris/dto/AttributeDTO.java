package com.commune.paris.dto;

import com.commune.paris.entity.PAttributeValue;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AttributeDTO {
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
    private List<PAttributeValue> valueList = new ArrayList<>();

    // tag标签使用
    private boolean inputVisible = false;
    private String inputValue ="";
}
