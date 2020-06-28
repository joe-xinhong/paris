package com.commune.paris.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PGoodsExample() {
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
            addCriterion("p_goods.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("p_goods.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("p_goods.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("p_goods.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("p_goods.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_goods.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("p_goods.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_goods.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("p_goods.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("p_goods.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("p_goods.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_goods.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNull() {
            addCriterion("p_goods.cate_id is null");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNotNull() {
            addCriterion("p_goods.cate_id is not null");
            return (Criteria) this;
        }

        public Criteria andCateIdEqualTo(Integer value) {
            addCriterion("p_goods.cate_id =", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotEqualTo(Integer value) {
            addCriterion("p_goods.cate_id <>", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThan(Integer value) {
            addCriterion("p_goods.cate_id >", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_goods.cate_id >=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThan(Integer value) {
            addCriterion("p_goods.cate_id <", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_goods.cate_id <=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdIn(List<Integer> values) {
            addCriterion("p_goods.cate_id in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotIn(List<Integer> values) {
            addCriterion("p_goods.cate_id not in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdBetween(Integer value1, Integer value2) {
            addCriterion("p_goods.cate_id between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_goods.cate_id not between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("p_goods.`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("p_goods.`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("p_goods.`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("p_goods.`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("p_goods.`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_goods.`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("p_goods.`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("p_goods.`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("p_goods.`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("p_goods.`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("p_goods.`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("p_goods.`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("p_goods.`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("p_goods.`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("p_goods.description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("p_goods.description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("p_goods.description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("p_goods.description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("p_goods.description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("p_goods.description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("p_goods.description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("p_goods.description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("p_goods.description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("p_goods.description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("p_goods.description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("p_goods.description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("p_goods.description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("p_goods.description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andBigImgIsNull() {
            addCriterion("p_goods.big_img is null");
            return (Criteria) this;
        }

        public Criteria andBigImgIsNotNull() {
            addCriterion("p_goods.big_img is not null");
            return (Criteria) this;
        }

        public Criteria andBigImgEqualTo(String value) {
            addCriterion("p_goods.big_img =", value, "bigImg");
            return (Criteria) this;
        }

        public Criteria andBigImgNotEqualTo(String value) {
            addCriterion("p_goods.big_img <>", value, "bigImg");
            return (Criteria) this;
        }

        public Criteria andBigImgGreaterThan(String value) {
            addCriterion("p_goods.big_img >", value, "bigImg");
            return (Criteria) this;
        }

        public Criteria andBigImgGreaterThanOrEqualTo(String value) {
            addCriterion("p_goods.big_img >=", value, "bigImg");
            return (Criteria) this;
        }

        public Criteria andBigImgLessThan(String value) {
            addCriterion("p_goods.big_img <", value, "bigImg");
            return (Criteria) this;
        }

        public Criteria andBigImgLessThanOrEqualTo(String value) {
            addCriterion("p_goods.big_img <=", value, "bigImg");
            return (Criteria) this;
        }

        public Criteria andBigImgLike(String value) {
            addCriterion("p_goods.big_img like", value, "bigImg");
            return (Criteria) this;
        }

        public Criteria andBigImgNotLike(String value) {
            addCriterion("p_goods.big_img not like", value, "bigImg");
            return (Criteria) this;
        }

        public Criteria andBigImgIn(List<String> values) {
            addCriterion("p_goods.big_img in", values, "bigImg");
            return (Criteria) this;
        }

        public Criteria andBigImgNotIn(List<String> values) {
            addCriterion("p_goods.big_img not in", values, "bigImg");
            return (Criteria) this;
        }

        public Criteria andBigImgBetween(String value1, String value2) {
            addCriterion("p_goods.big_img between", value1, value2, "bigImg");
            return (Criteria) this;
        }

        public Criteria andBigImgNotBetween(String value1, String value2) {
            addCriterion("p_goods.big_img not between", value1, value2, "bigImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgIsNull() {
            addCriterion("p_goods.small_img is null");
            return (Criteria) this;
        }

        public Criteria andSmallImgIsNotNull() {
            addCriterion("p_goods.small_img is not null");
            return (Criteria) this;
        }

        public Criteria andSmallImgEqualTo(String value) {
            addCriterion("p_goods.small_img =", value, "smallImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgNotEqualTo(String value) {
            addCriterion("p_goods.small_img <>", value, "smallImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgGreaterThan(String value) {
            addCriterion("p_goods.small_img >", value, "smallImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgGreaterThanOrEqualTo(String value) {
            addCriterion("p_goods.small_img >=", value, "smallImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgLessThan(String value) {
            addCriterion("p_goods.small_img <", value, "smallImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgLessThanOrEqualTo(String value) {
            addCriterion("p_goods.small_img <=", value, "smallImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgLike(String value) {
            addCriterion("p_goods.small_img like", value, "smallImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgNotLike(String value) {
            addCriterion("p_goods.small_img not like", value, "smallImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgIn(List<String> values) {
            addCriterion("p_goods.small_img in", values, "smallImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgNotIn(List<String> values) {
            addCriterion("p_goods.small_img not in", values, "smallImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgBetween(String value1, String value2) {
            addCriterion("p_goods.small_img between", value1, value2, "smallImg");
            return (Criteria) this;
        }

        public Criteria andSmallImgNotBetween(String value1, String value2) {
            addCriterion("p_goods.small_img not between", value1, value2, "smallImg");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("p_goods.introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("p_goods.introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("p_goods.introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("p_goods.introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("p_goods.introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("p_goods.introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("p_goods.introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("p_goods.introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("p_goods.introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("p_goods.introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("p_goods.introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("p_goods.introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("p_goods.introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("p_goods.introduce not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("p_goods.`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("p_goods.`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("p_goods.`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("p_goods.`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("p_goods.`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_goods.`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("p_goods.`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("p_goods.`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("p_goods.`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("p_goods.`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("p_goods.`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("p_goods.`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("p_goods.price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("p_goods.price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("p_goods.price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("p_goods.price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("p_goods.price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("p_goods.price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("p_goods.price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("p_goods.price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("p_goods.price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("p_goods.price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("p_goods.price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("p_goods.price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("p_goods.stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("p_goods.stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("p_goods.stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("p_goods.stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("p_goods.stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_goods.stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("p_goods.stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("p_goods.stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("p_goods.stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("p_goods.stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("p_goods.stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("p_goods.stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("p_goods.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("p_goods.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("p_goods.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("p_goods.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("p_goods.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("p_goods.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("p_goods.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("p_goods.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("p_goods.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("p_goods.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("p_goods.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("p_goods.create_time not between", value1, value2, "createTime");
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