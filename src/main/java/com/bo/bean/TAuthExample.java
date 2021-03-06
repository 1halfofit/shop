package com.bo.bean;

import java.util.ArrayList;
import java.util.List;

public class TAuthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAuthExample() {
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

        public Criteria andAuthidIsNull() {
            addCriterion("authid is null");
            return (Criteria) this;
        }

        public Criteria andAuthidIsNotNull() {
            addCriterion("authid is not null");
            return (Criteria) this;
        }

        public Criteria andAuthidEqualTo(Integer value) {
            addCriterion("authid =", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidNotEqualTo(Integer value) {
            addCriterion("authid <>", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidGreaterThan(Integer value) {
            addCriterion("authid >", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidGreaterThanOrEqualTo(Integer value) {
            addCriterion("authid >=", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidLessThan(Integer value) {
            addCriterion("authid <", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidLessThanOrEqualTo(Integer value) {
            addCriterion("authid <=", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidIn(List<Integer> values) {
            addCriterion("authid in", values, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidNotIn(List<Integer> values) {
            addCriterion("authid not in", values, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidBetween(Integer value1, Integer value2) {
            addCriterion("authid between", value1, value2, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidNotBetween(Integer value1, Integer value2) {
            addCriterion("authid not between", value1, value2, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthnameIsNull() {
            addCriterion("authname is null");
            return (Criteria) this;
        }

        public Criteria andAuthnameIsNotNull() {
            addCriterion("authname is not null");
            return (Criteria) this;
        }

        public Criteria andAuthnameEqualTo(String value) {
            addCriterion("authname =", value, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthnameNotEqualTo(String value) {
            addCriterion("authname <>", value, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthnameGreaterThan(String value) {
            addCriterion("authname >", value, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthnameGreaterThanOrEqualTo(String value) {
            addCriterion("authname >=", value, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthnameLessThan(String value) {
            addCriterion("authname <", value, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthnameLessThanOrEqualTo(String value) {
            addCriterion("authname <=", value, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthnameLike(String value) {
            addCriterion("authname like", value, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthnameNotLike(String value) {
            addCriterion("authname not like", value, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthnameIn(List<String> values) {
            addCriterion("authname in", values, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthnameNotIn(List<String> values) {
            addCriterion("authname not in", values, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthnameBetween(String value1, String value2) {
            addCriterion("authname between", value1, value2, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthnameNotBetween(String value1, String value2) {
            addCriterion("authname not between", value1, value2, "authname");
            return (Criteria) this;
        }

        public Criteria andAuthpathIsNull() {
            addCriterion("authpath is null");
            return (Criteria) this;
        }

        public Criteria andAuthpathIsNotNull() {
            addCriterion("authpath is not null");
            return (Criteria) this;
        }

        public Criteria andAuthpathEqualTo(String value) {
            addCriterion("authpath =", value, "authpath");
            return (Criteria) this;
        }

        public Criteria andAuthpathNotEqualTo(String value) {
            addCriterion("authpath <>", value, "authpath");
            return (Criteria) this;
        }

        public Criteria andAuthpathGreaterThan(String value) {
            addCriterion("authpath >", value, "authpath");
            return (Criteria) this;
        }

        public Criteria andAuthpathGreaterThanOrEqualTo(String value) {
            addCriterion("authpath >=", value, "authpath");
            return (Criteria) this;
        }

        public Criteria andAuthpathLessThan(String value) {
            addCriterion("authpath <", value, "authpath");
            return (Criteria) this;
        }

        public Criteria andAuthpathLessThanOrEqualTo(String value) {
            addCriterion("authpath <=", value, "authpath");
            return (Criteria) this;
        }

        public Criteria andAuthpathLike(String value) {
            addCriterion("authpath like", value, "authpath");
            return (Criteria) this;
        }

        public Criteria andAuthpathNotLike(String value) {
            addCriterion("authpath not like", value, "authpath");
            return (Criteria) this;
        }

        public Criteria andAuthpathIn(List<String> values) {
            addCriterion("authpath in", values, "authpath");
            return (Criteria) this;
        }

        public Criteria andAuthpathNotIn(List<String> values) {
            addCriterion("authpath not in", values, "authpath");
            return (Criteria) this;
        }

        public Criteria andAuthpathBetween(String value1, String value2) {
            addCriterion("authpath between", value1, value2, "authpath");
            return (Criteria) this;
        }

        public Criteria andAuthpathNotBetween(String value1, String value2) {
            addCriterion("authpath not between", value1, value2, "authpath");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andAuthdisIsNull() {
            addCriterion("authdis is null");
            return (Criteria) this;
        }

        public Criteria andAuthdisIsNotNull() {
            addCriterion("authdis is not null");
            return (Criteria) this;
        }

        public Criteria andAuthdisEqualTo(String value) {
            addCriterion("authdis =", value, "authdis");
            return (Criteria) this;
        }

        public Criteria andAuthdisNotEqualTo(String value) {
            addCriterion("authdis <>", value, "authdis");
            return (Criteria) this;
        }

        public Criteria andAuthdisGreaterThan(String value) {
            addCriterion("authdis >", value, "authdis");
            return (Criteria) this;
        }

        public Criteria andAuthdisGreaterThanOrEqualTo(String value) {
            addCriterion("authdis >=", value, "authdis");
            return (Criteria) this;
        }

        public Criteria andAuthdisLessThan(String value) {
            addCriterion("authdis <", value, "authdis");
            return (Criteria) this;
        }

        public Criteria andAuthdisLessThanOrEqualTo(String value) {
            addCriterion("authdis <=", value, "authdis");
            return (Criteria) this;
        }

        public Criteria andAuthdisLike(String value) {
            addCriterion("authdis like", value, "authdis");
            return (Criteria) this;
        }

        public Criteria andAuthdisNotLike(String value) {
            addCriterion("authdis not like", value, "authdis");
            return (Criteria) this;
        }

        public Criteria andAuthdisIn(List<String> values) {
            addCriterion("authdis in", values, "authdis");
            return (Criteria) this;
        }

        public Criteria andAuthdisNotIn(List<String> values) {
            addCriterion("authdis not in", values, "authdis");
            return (Criteria) this;
        }

        public Criteria andAuthdisBetween(String value1, String value2) {
            addCriterion("authdis between", value1, value2, "authdis");
            return (Criteria) this;
        }

        public Criteria andAuthdisNotBetween(String value1, String value2) {
            addCriterion("authdis not between", value1, value2, "authdis");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andIconclsIsNull() {
            addCriterion("iconcls is null");
            return (Criteria) this;
        }

        public Criteria andIconclsIsNotNull() {
            addCriterion("iconcls is not null");
            return (Criteria) this;
        }

        public Criteria andIconclsEqualTo(String value) {
            addCriterion("iconcls =", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsNotEqualTo(String value) {
            addCriterion("iconcls <>", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsGreaterThan(String value) {
            addCriterion("iconcls >", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsGreaterThanOrEqualTo(String value) {
            addCriterion("iconcls >=", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsLessThan(String value) {
            addCriterion("iconcls <", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsLessThanOrEqualTo(String value) {
            addCriterion("iconcls <=", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsLike(String value) {
            addCriterion("iconcls like", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsNotLike(String value) {
            addCriterion("iconcls not like", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsIn(List<String> values) {
            addCriterion("iconcls in", values, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsNotIn(List<String> values) {
            addCriterion("iconcls not in", values, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsBetween(String value1, String value2) {
            addCriterion("iconcls between", value1, value2, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsNotBetween(String value1, String value2) {
            addCriterion("iconcls not between", value1, value2, "iconcls");
            return (Criteria) this;
        }
    }

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