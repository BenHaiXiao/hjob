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
public class ScheduleJobQueryRequest {
  /**
   * 任务Id
   *
   */
  public long jobId; // optional
  /**
   * 任务名
   *
   */
  public String jobName; // optional
  /**
   * 调度任务组。
   *
   */
  public String jobGroup; // optional

  public long getJobId() {
    return jobId;
  }

  public void setJobId(long jobId) {
    this.jobId = jobId;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public String getJobGroup() {
    return jobGroup;
  }

  public void setJobGroup(String jobGroup) {
    this.jobGroup = jobGroup;
  }
}