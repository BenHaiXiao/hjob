package com.github.bh.hjob.core.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaobenhai trigger各状态说明：
 *
 * None：Trigger已经完成，且不会在执行，或者找不到该触发器，或者Trigger已经被删除 NORMAL:正常状态 PAUSED：暂停状态 COMPLETE：触发器完成，但是任务可能还正在执行中 BLOCKED：线程阻塞状态 ERROR：出现错误
 */

public class ScheduleJob implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8168162344586006563L;

    /**
     * 任务id
     */
    private long jobId;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务消息通知key
     */
    private String jobNotifyKey;

    /**
     * 任务分组
     */
    private String jobGroup;

    /**
     * quartz任务状态
     */
    private String jobDetailStatus;

    private int jobStatus;

    /**
     * 任务运行时间表达式
     */
    private String cronexpression;

    /**
     * 前一次运行时间
     */
    private Date previousTime;

    /**
     * 下次运行时间
     */
    private Date nextTime;

	/**
	 * 描述
	 */
	private String description;


    public ScheduleJob() {
        super();
    }


    public Date getPreviousTime() {
        return previousTime;
    }

    public void setPreviousTime(Date previousTime) {
        this.previousTime = previousTime;
    }

    public Date getNextTime() {
        return nextTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
    }

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

    public int getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronexpression() {
        return cronexpression;
    }

    public void setCronexpression(String cronexpression) {
        this.cronexpression = cronexpression;
    }

    public String getJobDetailStatus() {
        return jobDetailStatus;
    }

    public void setJobDetailStatus(String jobDetailStatus) {
        this.jobDetailStatus = jobDetailStatus;
    }

    public String getJobNotifyKey() {
        return jobNotifyKey;
    }

    public void setJobNotifyKey(String jobNotifyKey) {
        this.jobNotifyKey = jobNotifyKey;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
    public String toString() {
        return "ScheduleJob{" +
               "jobId=" + jobId +
               ", jobName='" + jobName + '\'' +
               ", jobNotifyKey='" + jobNotifyKey + '\'' +
               ", jobGroup='" + jobGroup + '\'' +
               ", jobDetailStatus='" + jobDetailStatus + '\'' +
               ", jobStatus=" + jobStatus +
               ", cronexpression='" + cronexpression + '\'' +
               ", previousTime=" + previousTime +
               ", nextTime=" + nextTime +
				", description=" + description +
               '}';
    }
}
