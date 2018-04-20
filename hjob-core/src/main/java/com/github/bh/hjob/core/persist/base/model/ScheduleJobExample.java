package com.github.bh.hjob.core.persist.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleJobExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    public ScheduleJobExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
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

        public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(Long value) {
            addCriterion("job_id =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(Long value) {
            addCriterion("job_id <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(Long value) {
            addCriterion("job_id >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(Long value) {
            addCriterion("job_id >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(Long value) {
            addCriterion("job_id <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(Long value) {
            addCriterion("job_id <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<Long> values) {
            addCriterion("job_id in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<Long> values) {
            addCriterion("job_id not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(Long value1, Long value2) {
            addCriterion("job_id between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(Long value1, Long value2) {
            addCriterion("job_id not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNull() {
            addCriterion("job_group is null");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNotNull() {
            addCriterion("job_group is not null");
            return (Criteria) this;
        }

        public Criteria andJobGroupEqualTo(String value) {
            addCriterion("job_group =", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotEqualTo(String value) {
            addCriterion("job_group <>", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThan(String value) {
            addCriterion("job_group >", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThanOrEqualTo(String value) {
            addCriterion("job_group >=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThan(String value) {
            addCriterion("job_group <", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThanOrEqualTo(String value) {
            addCriterion("job_group <=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLike(String value) {
            addCriterion("job_group like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotLike(String value) {
            addCriterion("job_group not like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupIn(List<String> values) {
            addCriterion("job_group in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotIn(List<String> values) {
            addCriterion("job_group not in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupBetween(String value1, String value2) {
            addCriterion("job_group between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotBetween(String value1, String value2) {
            addCriterion("job_group not between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyIsNull() {
            addCriterion("job_notify_key is null");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyIsNotNull() {
            addCriterion("job_notify_key is not null");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyEqualTo(String value) {
            addCriterion("job_notify_key =", value, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyNotEqualTo(String value) {
            addCriterion("job_notify_key <>", value, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyGreaterThan(String value) {
            addCriterion("job_notify_key >", value, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyGreaterThanOrEqualTo(String value) {
            addCriterion("job_notify_key >=", value, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyLessThan(String value) {
            addCriterion("job_notify_key <", value, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyLessThanOrEqualTo(String value) {
            addCriterion("job_notify_key <=", value, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyLike(String value) {
            addCriterion("job_notify_key like", value, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyNotLike(String value) {
            addCriterion("job_notify_key not like", value, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyIn(List<String> values) {
            addCriterion("job_notify_key in", values, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyNotIn(List<String> values) {
            addCriterion("job_notify_key not in", values, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyBetween(String value1, String value2) {
            addCriterion("job_notify_key between", value1, value2, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobNotifyKeyNotBetween(String value1, String value2) {
            addCriterion("job_notify_key not between", value1, value2, "jobNotifyKey");
            return (Criteria) this;
        }

        public Criteria andJobStatusIsNull() {
            addCriterion("job_status is null");
            return (Criteria) this;
        }

        public Criteria andJobStatusIsNotNull() {
            addCriterion("job_status is not null");
            return (Criteria) this;
        }

        public Criteria andJobStatusEqualTo(Integer value) {
            addCriterion("job_status =", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotEqualTo(Integer value) {
            addCriterion("job_status <>", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusGreaterThan(Integer value) {
            addCriterion("job_status >", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_status >=", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusLessThan(Integer value) {
            addCriterion("job_status <", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusLessThanOrEqualTo(Integer value) {
            addCriterion("job_status <=", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusIn(List<Integer> values) {
            addCriterion("job_status in", values, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotIn(List<Integer> values) {
            addCriterion("job_status not in", values, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusBetween(Integer value1, Integer value2) {
            addCriterion("job_status between", value1, value2, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("job_status not between", value1, value2, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusIsNull() {
            addCriterion("job_detail_status is null");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusIsNotNull() {
            addCriterion("job_detail_status is not null");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusEqualTo(String value) {
            addCriterion("job_detail_status =", value, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusNotEqualTo(String value) {
            addCriterion("job_detail_status <>", value, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusGreaterThan(String value) {
            addCriterion("job_detail_status >", value, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusGreaterThanOrEqualTo(String value) {
            addCriterion("job_detail_status >=", value, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusLessThan(String value) {
            addCriterion("job_detail_status <", value, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusLessThanOrEqualTo(String value) {
            addCriterion("job_detail_status <=", value, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusLike(String value) {
            addCriterion("job_detail_status like", value, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusNotLike(String value) {
            addCriterion("job_detail_status not like", value, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusIn(List<String> values) {
            addCriterion("job_detail_status in", values, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusNotIn(List<String> values) {
            addCriterion("job_detail_status not in", values, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusBetween(String value1, String value2) {
            addCriterion("job_detail_status between", value1, value2, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andJobDetailStatusNotBetween(String value1, String value2) {
            addCriterion("job_detail_status not between", value1, value2, "jobDetailStatus");
            return (Criteria) this;
        }

        public Criteria andCronexpressionIsNull() {
            addCriterion("cronexpression is null");
            return (Criteria) this;
        }

        public Criteria andCronexpressionIsNotNull() {
            addCriterion("cronexpression is not null");
            return (Criteria) this;
        }

        public Criteria andCronexpressionEqualTo(String value) {
            addCriterion("cronexpression =", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotEqualTo(String value) {
            addCriterion("cronexpression <>", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionGreaterThan(String value) {
            addCriterion("cronexpression >", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionGreaterThanOrEqualTo(String value) {
            addCriterion("cronexpression >=", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionLessThan(String value) {
            addCriterion("cronexpression <", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionLessThanOrEqualTo(String value) {
            addCriterion("cronexpression <=", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionLike(String value) {
            addCriterion("cronexpression like", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotLike(String value) {
            addCriterion("cronexpression not like", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionIn(List<String> values) {
            addCriterion("cronexpression in", values, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotIn(List<String> values) {
            addCriterion("cronexpression not in", values, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionBetween(String value1, String value2) {
            addCriterion("cronexpression between", value1, value2, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotBetween(String value1, String value2) {
            addCriterion("cronexpression not between", value1, value2, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeIsNull() {
            addCriterion("previous_time is null");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeIsNotNull() {
            addCriterion("previous_time is not null");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeEqualTo(Date value) {
            addCriterion("previous_time =", value, "previousTime");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeNotEqualTo(Date value) {
            addCriterion("previous_time <>", value, "previousTime");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeGreaterThan(Date value) {
            addCriterion("previous_time >", value, "previousTime");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("previous_time >=", value, "previousTime");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeLessThan(Date value) {
            addCriterion("previous_time <", value, "previousTime");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeLessThanOrEqualTo(Date value) {
            addCriterion("previous_time <=", value, "previousTime");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeIn(List<Date> values) {
            addCriterion("previous_time in", values, "previousTime");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeNotIn(List<Date> values) {
            addCriterion("previous_time not in", values, "previousTime");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeBetween(Date value1, Date value2) {
            addCriterion("previous_time between", value1, value2, "previousTime");
            return (Criteria) this;
        }

        public Criteria andPreviousTimeNotBetween(Date value1, Date value2) {
            addCriterion("previous_time not between", value1, value2, "previousTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeIsNull() {
            addCriterion("next_time is null");
            return (Criteria) this;
        }

        public Criteria andNextTimeIsNotNull() {
            addCriterion("next_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextTimeEqualTo(Date value) {
            addCriterion("next_time =", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeNotEqualTo(Date value) {
            addCriterion("next_time <>", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeGreaterThan(Date value) {
            addCriterion("next_time >", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("next_time >=", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeLessThan(Date value) {
            addCriterion("next_time <", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeLessThanOrEqualTo(Date value) {
            addCriterion("next_time <=", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeIn(List<Date> values) {
            addCriterion("next_time in", values, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeNotIn(List<Date> values) {
            addCriterion("next_time not in", values, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeBetween(Date value1, Date value2) {
            addCriterion("next_time between", value1, value2, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeNotBetween(Date value1, Date value2) {
            addCriterion("next_time not between", value1, value2, "nextTime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table schedule_job
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
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