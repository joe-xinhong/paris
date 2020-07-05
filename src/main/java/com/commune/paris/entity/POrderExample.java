package com.commune.paris.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class POrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public POrderExample() {
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
            addCriterion("p_order.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("p_order.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("p_order.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("p_order.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("p_order.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_order.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("p_order.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_order.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("p_order.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("p_order.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("p_order.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_order.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("p_order.order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("p_order.order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("p_order.order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("p_order.order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("p_order.order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("p_order.order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("p_order.order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("p_order.order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("p_order.order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("p_order.order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("p_order.order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("p_order.order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("p_order.order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("p_order.order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("p_order.user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("p_order.user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("p_order.user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("p_order.user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("p_order.user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_order.user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("p_order.user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_order.user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("p_order.user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("p_order.user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("p_order.user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_order.user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPayStatueIsNull() {
            addCriterion("p_order.pay_statue is null");
            return (Criteria) this;
        }

        public Criteria andPayStatueIsNotNull() {
            addCriterion("p_order.pay_statue is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatueEqualTo(Integer value) {
            addCriterion("p_order.pay_statue =", value, "payStatue");
            return (Criteria) this;
        }

        public Criteria andPayStatueNotEqualTo(Integer value) {
            addCriterion("p_order.pay_statue <>", value, "payStatue");
            return (Criteria) this;
        }

        public Criteria andPayStatueGreaterThan(Integer value) {
            addCriterion("p_order.pay_statue >", value, "payStatue");
            return (Criteria) this;
        }

        public Criteria andPayStatueGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_order.pay_statue >=", value, "payStatue");
            return (Criteria) this;
        }

        public Criteria andPayStatueLessThan(Integer value) {
            addCriterion("p_order.pay_statue <", value, "payStatue");
            return (Criteria) this;
        }

        public Criteria andPayStatueLessThanOrEqualTo(Integer value) {
            addCriterion("p_order.pay_statue <=", value, "payStatue");
            return (Criteria) this;
        }

        public Criteria andPayStatueIn(List<Integer> values) {
            addCriterion("p_order.pay_statue in", values, "payStatue");
            return (Criteria) this;
        }

        public Criteria andPayStatueNotIn(List<Integer> values) {
            addCriterion("p_order.pay_statue not in", values, "payStatue");
            return (Criteria) this;
        }

        public Criteria andPayStatueBetween(Integer value1, Integer value2) {
            addCriterion("p_order.pay_statue between", value1, value2, "payStatue");
            return (Criteria) this;
        }

        public Criteria andPayStatueNotBetween(Integer value1, Integer value2) {
            addCriterion("p_order.pay_statue not between", value1, value2, "payStatue");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNull() {
            addCriterion("p_order.send_status is null");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNotNull() {
            addCriterion("p_order.send_status is not null");
            return (Criteria) this;
        }

        public Criteria andSendStatusEqualTo(Integer value) {
            addCriterion("p_order.send_status =", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotEqualTo(Integer value) {
            addCriterion("p_order.send_status <>", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThan(Integer value) {
            addCriterion("p_order.send_status >", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_order.send_status >=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThan(Integer value) {
            addCriterion("p_order.send_status <", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("p_order.send_status <=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusIn(List<Integer> values) {
            addCriterion("p_order.send_status in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotIn(List<Integer> values) {
            addCriterion("p_order.send_status not in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusBetween(Integer value1, Integer value2) {
            addCriterion("p_order.send_status between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("p_order.send_status not between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andBillTitleIsNull() {
            addCriterion("p_order.bill_title is null");
            return (Criteria) this;
        }

        public Criteria andBillTitleIsNotNull() {
            addCriterion("p_order.bill_title is not null");
            return (Criteria) this;
        }

        public Criteria andBillTitleEqualTo(String value) {
            addCriterion("p_order.bill_title =", value, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillTitleNotEqualTo(String value) {
            addCriterion("p_order.bill_title <>", value, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillTitleGreaterThan(String value) {
            addCriterion("p_order.bill_title >", value, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillTitleGreaterThanOrEqualTo(String value) {
            addCriterion("p_order.bill_title >=", value, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillTitleLessThan(String value) {
            addCriterion("p_order.bill_title <", value, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillTitleLessThanOrEqualTo(String value) {
            addCriterion("p_order.bill_title <=", value, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillTitleLike(String value) {
            addCriterion("p_order.bill_title like", value, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillTitleNotLike(String value) {
            addCriterion("p_order.bill_title not like", value, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillTitleIn(List<String> values) {
            addCriterion("p_order.bill_title in", values, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillTitleNotIn(List<String> values) {
            addCriterion("p_order.bill_title not in", values, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillTitleBetween(String value1, String value2) {
            addCriterion("p_order.bill_title between", value1, value2, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillTitleNotBetween(String value1, String value2) {
            addCriterion("p_order.bill_title not between", value1, value2, "billTitle");
            return (Criteria) this;
        }

        public Criteria andBillCompanyIsNull() {
            addCriterion("p_order.bill_company is null");
            return (Criteria) this;
        }

        public Criteria andBillCompanyIsNotNull() {
            addCriterion("p_order.bill_company is not null");
            return (Criteria) this;
        }

        public Criteria andBillCompanyEqualTo(String value) {
            addCriterion("p_order.bill_company =", value, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillCompanyNotEqualTo(String value) {
            addCriterion("p_order.bill_company <>", value, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillCompanyGreaterThan(String value) {
            addCriterion("p_order.bill_company >", value, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("p_order.bill_company >=", value, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillCompanyLessThan(String value) {
            addCriterion("p_order.bill_company <", value, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillCompanyLessThanOrEqualTo(String value) {
            addCriterion("p_order.bill_company <=", value, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillCompanyLike(String value) {
            addCriterion("p_order.bill_company like", value, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillCompanyNotLike(String value) {
            addCriterion("p_order.bill_company not like", value, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillCompanyIn(List<String> values) {
            addCriterion("p_order.bill_company in", values, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillCompanyNotIn(List<String> values) {
            addCriterion("p_order.bill_company not in", values, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillCompanyBetween(String value1, String value2) {
            addCriterion("p_order.bill_company between", value1, value2, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillCompanyNotBetween(String value1, String value2) {
            addCriterion("p_order.bill_company not between", value1, value2, "billCompany");
            return (Criteria) this;
        }

        public Criteria andBillContentIsNull() {
            addCriterion("p_order.bill_content is null");
            return (Criteria) this;
        }

        public Criteria andBillContentIsNotNull() {
            addCriterion("p_order.bill_content is not null");
            return (Criteria) this;
        }

        public Criteria andBillContentEqualTo(String value) {
            addCriterion("p_order.bill_content =", value, "billContent");
            return (Criteria) this;
        }

        public Criteria andBillContentNotEqualTo(String value) {
            addCriterion("p_order.bill_content <>", value, "billContent");
            return (Criteria) this;
        }

        public Criteria andBillContentGreaterThan(String value) {
            addCriterion("p_order.bill_content >", value, "billContent");
            return (Criteria) this;
        }

        public Criteria andBillContentGreaterThanOrEqualTo(String value) {
            addCriterion("p_order.bill_content >=", value, "billContent");
            return (Criteria) this;
        }

        public Criteria andBillContentLessThan(String value) {
            addCriterion("p_order.bill_content <", value, "billContent");
            return (Criteria) this;
        }

        public Criteria andBillContentLessThanOrEqualTo(String value) {
            addCriterion("p_order.bill_content <=", value, "billContent");
            return (Criteria) this;
        }

        public Criteria andBillContentLike(String value) {
            addCriterion("p_order.bill_content like", value, "billContent");
            return (Criteria) this;
        }

        public Criteria andBillContentNotLike(String value) {
            addCriterion("p_order.bill_content not like", value, "billContent");
            return (Criteria) this;
        }

        public Criteria andBillContentIn(List<String> values) {
            addCriterion("p_order.bill_content in", values, "billContent");
            return (Criteria) this;
        }

        public Criteria andBillContentNotIn(List<String> values) {
            addCriterion("p_order.bill_content not in", values, "billContent");
            return (Criteria) this;
        }

        public Criteria andBillContentBetween(String value1, String value2) {
            addCriterion("p_order.bill_content between", value1, value2, "billContent");
            return (Criteria) this;
        }

        public Criteria andBillContentNotBetween(String value1, String value2) {
            addCriterion("p_order.bill_content not between", value1, value2, "billContent");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("p_order.address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("p_order.address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("p_order.address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("p_order.address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("p_order.address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("p_order.address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("p_order.address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("p_order.address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("p_order.address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("p_order.address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("p_order.address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("p_order.address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("p_order.address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("p_order.address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("p_order.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("p_order.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("p_order.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("p_order.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("p_order.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("p_order.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("p_order.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("p_order.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("p_order.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("p_order.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("p_order.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("p_order.create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("p_order.update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("p_order.update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("p_order.update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("p_order.update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("p_order.update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("p_order.update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("p_order.update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("p_order.update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("p_order.update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("p_order.update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("p_order.update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("p_order.update_time not between", value1, value2, "updateTime");
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