package com.commune.paris.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * p_attribute_value
 * @author 
 */
public class PAttributeValue implements Serializable {
    /**
     * 属性输入值id
     */
    private Integer id;

    /**
     * 所属属性id
     */
    private Integer attributeId;

    /**
     * 属性值
     */
    @NotBlank(message = "参数项名称不能为空")
    private String attributeVal;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeVal() {
        return attributeVal;
    }

    public void setAttributeVal(String attributeVal) {
        this.attributeVal = attributeVal;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PAttributeValue other = (PAttributeValue) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAttributeId() == null ? other.getAttributeId() == null : this.getAttributeId().equals(other.getAttributeId()))
            && (this.getAttributeVal() == null ? other.getAttributeVal() == null : this.getAttributeVal().equals(other.getAttributeVal()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAttributeId() == null) ? 0 : getAttributeId().hashCode());
        result = prime * result + ((getAttributeVal() == null) ? 0 : getAttributeVal().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attributeId=").append(attributeId);
        sb.append(", attributeVal=").append(attributeVal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}