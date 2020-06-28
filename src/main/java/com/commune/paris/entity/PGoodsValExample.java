package com.commune.paris.entity;

import java.util.ArrayList;
import java.util.List;

public class PGoodsValExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PGoodsValExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("p_goods_val.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("p_goods_val.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("p_goods_val.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("p_goods_val.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("p_goods_val.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_goods_val.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("p_goods_val.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_goods_val.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("p_goods_val.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("p_goods_val.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("p_goods_val.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_goods_val.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("p_goods_val.goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("p_goods_val.goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("p_goods_val.goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("p_goods_val.goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("p_goods_val.goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_goods_val.goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("p_goods_val.goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_goods_val.goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("p_goods_val.goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("p_goods_val.goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("p_goods_val.goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_goods_val.goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andAttributeIdIsNull() {
            addCriterion("p_goods_val.attribute_id is null");
            return (Criteria) this;
        }

        public Criteria andAttributeIdIsNotNull() {
            addCriterion("p_goods_val.attribute_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeIdEqualTo(Integer value) {
            addCriterion("p_goods_val.attribute_id =", value, "attributeId");
            return (Criteria) this;
        }

        public Criteria andAttributeIdNotEqualTo(Integer value) {
            addCriterion("p_goods_val.attribute_id <>", value, "attributeId");
            return (Criteria) this;
        }

        public Criteria andAttributeIdGreaterThan(Integer value) {
            addCriterion("p_goods_val.attribute_id >", value, "attributeId");
            return (Criteria) this;
        }

        public Criteria andAttributeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_goods_val.attribute_id >=", value, "attributeId");
            return (Criteria) this;
        }

        public Criteria andAttributeIdLessThan(Integer value) {
            addCriterion("p_goods_val.attribute_id <", value, "attributeId");
            return (Criteria) this;
        }

        public Criteria andAttributeIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_goods_val.attribute_id <=", value, "attributeId");
            return (Criteria) this;
        }

        public Criteria andAttributeIdIn(List<Integer> values) {
            addCriterion("p_goods_val.attribute_id in", values, "attributeId");
            return (Criteria) this;
        }

        public Criteria andAttributeIdNotIn(List<Integer> values) {
            addCriterion("p_goods_val.attribute_id not in", values, "attributeId");
            return (Criteria) this;
        }

        public Criteria andAttributeIdBetween(Integer value1, Integer value2) {
            addCriterion("p_goods_val.attribute_id between", value1, value2, "attributeId");
            return (Criteria) this;
        }

        public Criteria andAttributeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_goods_val.attribute_id not between", value1, value2, "attributeId");
            return (Criteria) this;
        }

        public Criteria andValIdIsNull() {
            addCriterion("p_goods_val.val_id is null");
            return (Criteria) this;
        }

        public Criteria andValIdIsNotNull() {
            addCriterion("p_goods_val.val_id is not null");
            return (Criteria) this;
        }

        public Criteria andValIdEqualTo(Integer value) {
            addCriterion("p_goods_val.val_id =", value, "valId");
            return (Criteria) this;
        }

        public Criteria andValIdNotEqualTo(Integer value) {
            addCriterion("p_goods_val.val_id <>", value, "valId");
            return (Criteria) this;
        }

        public Criteria andValIdGreaterThan(Integer value) {
            addCriterion("p_goods_val.val_id >", value, "valId");
            return (Criteria) this;
        }

        public Criteria andValIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_goods_val.val_id >=", value, "valId");
            return (Criteria) this;
        }

        public Criteria andValIdLessThan(Integer value) {
            addCriterion("p_goods_val.val_id <", value, "valId");
            return (Criteria) this;
        }

        public Criteria andValIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_goods_val.val_id <=", value, "valId");
            return (Criteria) this;
        }

        public Criteria andValIdIn(List<Integer> values) {
            addCriterion("p_goods_val.val_id in", values, "valId");
            return (Criteria) this;
        }

        public Criteria andValIdNotIn(List<Integer> values) {
            addCriterion("p_goods_val.val_id not in", values, "valId");
            return (Criteria) this;
        }

        public Criteria andValIdBetween(Integer value1, Integer value2) {
            addCriterion("p_goods_val.val_id between", value1, value2, "valId");
            return (Criteria) this;
        }

        public Criteria andValIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_goods_val.val_id not between", value1, value2, "valId");
            return (Criteria) this;
        }

        public Criteria andValStringIsNull() {
            addCriterion("p_goods_val.val_string is null");
            return (Criteria) this;
        }

        public Criteria andValStringIsNotNull() {
            addCriterion("p_goods_val.val_string is not null");
            return (Criteria) this;
        }

        public Criteria andValStringEqualTo(String value) {
            addCriterion("p_goods_val.val_string =", value, "valString");
            return (Criteria) this;
        }

        public Criteria andValStringNotEqualTo(String value) {
            addCriterion("p_goods_val.val_string <>", value, "valString");
            return (Criteria) this;
        }

        public Criteria andValStringGreaterThan(String value) {
            addCriterion("p_goods_val.val_string >", value, "valString");
            return (Criteria) this;
        }

        public Criteria andValStringGreaterThanOrEqualTo(String value) {
            addCriterion("p_goods_val.val_string >=", value, "valString");
            return (Criteria) this;
        }

        public Criteria andValStringLessThan(String value) {
            addCriterion("p_goods_val.val_string <", value, "valString");
            return (Criteria) this;
        }

        public Criteria andValStringLessThanOrEqualTo(String value) {
            addCriterion("p_goods_val.val_string <=", value, "valString");
            return (Criteria) this;
        }

        public Criteria andValStringLike(String value) {
            addCriterion("p_goods_val.val_string like", value, "valString");
            return (Criteria) this;
        }

        public Criteria andValStringNotLike(String value) {
            addCriterion("p_goods_val.val_string not like", value, "valString");
            return (Criteria) this;
        }

        public Criteria andValStringIn(List<String> values) {
            addCriterion("p_goods_val.val_string in", values, "valString");
            return (Criteria) this;
        }

        public Criteria andValStringNotIn(List<String> values) {
            addCriterion("p_goods_val.val_string not in", values, "valString");
            return (Criteria) this;
        }

        public Criteria andValStringBetween(String value1, String value2) {
            addCriterion("p_goods_val.val_string between", value1, value2, "valString");
            return (Criteria) this;
        }

        public Criteria andValStringNotBetween(String value1, String value2) {
            addCriterion("p_goods_val.val_string not between", value1, value2, "valString");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}