package com.commune.paris.entity;

import java.io.Serializable;

/**
 * p_goods_val
 * @author 
 */
public class PGoodsVal implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品动态参数对应id
     */
    private Integer attributeId;

    /**
     * 动态参数id对应选中值id
     */
    private Integer valId;

    /**
     * 静态属性值答案
     */
    private String valString;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public Integer getValId() {
        return valId;
    }

    public void setValId(Integer valId) {
        this.valId = valId;
    }

    public String getValString() {
        return valString;
    }

    public void setValString(String valString) {
        this.valString = valString;
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
        PGoodsVal other = (PGoodsVal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getAttributeId() == null ? other.getAttributeId() == null : this.getAttributeId().equals(other.getAttributeId()))
            && (this.getValId() == null ? other.getValId() == null : this.getValId().equals(other.getValId()))
            && (this.getValString() == null ? other.getValString() == null : this.getValString().equals(other.getValString()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getAttributeId() == null) ? 0 : getAttributeId().hashCode());
        result = prime * result + ((getValId() == null) ? 0 : getValId().hashCode());
        result = prime * result + ((getValString() == null) ? 0 : getValString().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", attributeId=").append(attributeId);
        sb.append(", valId=").append(valId);
        sb.append(", valString=").append(valString);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}