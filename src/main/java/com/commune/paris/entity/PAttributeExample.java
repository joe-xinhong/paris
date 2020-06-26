package com.commune.paris.entity;

import java.util.ArrayList;
import java.util.List;

public class PAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PAttributeExample() {
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
            addCriterion("p_attribute.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("p_attribute.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("p_attribute.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("p_attribute.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("p_attribute.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_attribute.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("p_attribute.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_attribute.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("p_attribute.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("p_attribute.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("p_attribute.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_attribute.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("p_attribute.`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("p_attribute.`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("p_attribute.`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("p_attribute.`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("p_attribute.`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_attribute.`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("p_attribute.`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("p_attribute.`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("p_attribute.`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("p_attribute.`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("p_attribute.`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("p_attribute.`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("p_attribute.`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("p_attribute.`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNull() {
            addCriterion("p_attribute.cate_id is null");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNotNull() {
            addCriterion("p_attribute.cate_id is not null");
            return (Criteria) this;
        }

        public Criteria andCateIdEqualTo(Integer value) {
            addCriterion("p_attribute.cate_id =", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotEqualTo(Integer value) {
            addCriterion("p_attribute.cate_id <>", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThan(Integer value) {
            addCriterion("p_attribute.cate_id >", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_attribute.cate_id >=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThan(Integer value) {
            addCriterion("p_attribute.cate_id <", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_attribute.cate_id <=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdIn(List<Integer> values) {
            addCriterion("p_attribute.cate_id in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotIn(List<Integer> values) {
            addCriterion("p_attribute.cate_id not in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdBetween(Integer value1, Integer value2) {
            addCriterion("p_attribute.cate_id between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_attribute.cate_id not between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andSelIsNull() {
            addCriterion("p_attribute.sel is null");
            return (Criteria) this;
        }

        public Criteria andSelIsNotNull() {
            addCriterion("p_attribute.sel is not null");
            return (Criteria) this;
        }

        public Criteria andSelEqualTo(String value) {
            addCriterion("p_attribute.sel =", value, "sel");
            return (Criteria) this;
        }

        public Criteria andSelNotEqualTo(String value) {
            addCriterion("p_attribute.sel <>", value, "sel");
            return (Criteria) this;
        }

        public Criteria andSelGreaterThan(String value) {
            addCriterion("p_attribute.sel >", value, "sel");
            return (Criteria) this;
        }

        public Criteria andSelGreaterThanOrEqualTo(String value) {
            addCriterion("p_attribute.sel >=", value, "sel");
            return (Criteria) this;
        }

        public Criteria andSelLessThan(String value) {
            addCriterion("p_attribute.sel <", value, "sel");
            return (Criteria) this;
        }

        public Criteria andSelLessThanOrEqualTo(String value) {
            addCriterion("p_attribute.sel <=", value, "sel");
            return (Criteria) this;
        }

        public Criteria andSelLike(String value) {
            addCriterion("p_attribute.sel like", value, "sel");
            return (Criteria) this;
        }

        public Criteria andSelNotLike(String value) {
            addCriterion("p_attribute.sel not like", value, "sel");
            return (Criteria) this;
        }

        public Criteria andSelIn(List<String> values) {
            addCriterion("p_attribute.sel in", values, "sel");
            return (Criteria) this;
        }

        public Criteria andSelNotIn(List<String> values) {
            addCriterion("p_attribute.sel not in", values, "sel");
            return (Criteria) this;
        }

        public Criteria andSelBetween(String value1, String value2) {
            addCriterion("p_attribute.sel between", value1, value2, "sel");
            return (Criteria) this;
        }

        public Criteria andSelNotBetween(String value1, String value2) {
            addCriterion("p_attribute.sel not between", value1, value2, "sel");
            return (Criteria) this;
        }

        public Criteria andWriteIsNull() {
            addCriterion("p_attribute.`write` is null");
            return (Criteria) this;
        }

        public Criteria andWriteIsNotNull() {
            addCriterion("p_attribute.`write` is not null");
            return (Criteria) this;
        }

        public Criteria andWriteEqualTo(String value) {
            addCriterion("p_attribute.`write` =", value, "write");
            return (Criteria) this;
        }

        public Criteria andWriteNotEqualTo(String value) {
            addCriterion("p_attribute.`write` <>", value, "write");
            return (Criteria) this;
        }

        public Criteria andWriteGreaterThan(String value) {
            addCriterion("p_attribute.`write` >", value, "write");
            return (Criteria) this;
        }

        public Criteria andWriteGreaterThanOrEqualTo(String value) {
            addCriterion("p_attribute.`write` >=", value, "write");
            return (Criteria) this;
        }

        public Criteria andWriteLessThan(String value) {
            addCriterion("p_attribute.`write` <", value, "write");
            return (Criteria) this;
        }

        public Criteria andWriteLessThanOrEqualTo(String value) {
            addCriterion("p_attribute.`write` <=", value, "write");
            return (Criteria) this;
        }

        public Criteria andWriteLike(String value) {
            addCriterion("p_attribute.`write` like", value, "write");
            return (Criteria) this;
        }

        public Criteria andWriteNotLike(String value) {
            addCriterion("p_attribute.`write` not like", value, "write");
            return (Criteria) this;
        }

        public Criteria andWriteIn(List<String> values) {
            addCriterion("p_attribute.`write` in", values, "write");
            return (Criteria) this;
        }

        public Criteria andWriteNotIn(List<String> values) {
            addCriterion("p_attribute.`write` not in", values, "write");
            return (Criteria) this;
        }

        public Criteria andWriteBetween(String value1, String value2) {
            addCriterion("p_attribute.`write` between", value1, value2, "write");
            return (Criteria) this;
        }

        public Criteria andWriteNotBetween(String value1, String value2) {
            addCriterion("p_attribute.`write` not between", value1, value2, "write");
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