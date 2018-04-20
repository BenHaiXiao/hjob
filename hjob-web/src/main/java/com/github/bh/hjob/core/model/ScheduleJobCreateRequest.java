/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.github.bh.hjob.core.model;
/**
 * @author xiaobenhai
 */
public class ScheduleJobCreateRequest {
  /**
   * 任务名
   *
   */
  public String jobName; // required
  /**
   * 调度任务Key。
   *
   */
  public String jobNotifyKey; // required
  /**
   * 调度任务时间表达式
   *
   */
  public String cronexpression; // required
  /**
   * 调度任务组
   *
   */
  public String jobGroup; // optional
  /**
   * 描述
   *
   */
  public String description; // optional

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public String getJobNotifyKey() {
    return jobNotifyKey;
  }

  public void setJobNotifyKey(String jobNotifyKey) {
    this.jobNotifyKey = jobNotifyKey;
  }

  public String getCronexpression() {
    return cronexpression;
  }

  public void setCronexpression(String cronexpression) {
    this.cronexpression = cronexpression;
  }

  public String getJobGroup() {
    return jobGroup;
  }

  public void setJobGroup(String jobGroup) {
    this.jobGroup = jobGroup;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}