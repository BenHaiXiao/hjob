package com.github.bh.hjob.core.model;

/**
 * @author xiaobenhai
 */
public class ScheduleJobVo {
	private Long jobId;
	private String jobName;
	private String jobGroup;
	private String jobDetailStatus;
	private Integer jobStatus;
	private String cronexpression;
	private Long nextTime;
	private Long previousTime;
	private String description;
	private String mqKey;

	@Override
	public String toString() {
		return "ScheduleJobVo{" +
				"jobId=" + jobId +
				", jobName='" + jobName + '\'' +
				", jobGroup='" + jobGroup + '\'' +
				", jobDetailStatus='" + jobDetailStatus + '\'' +
				", jobStatus=" + jobStatus +
				", cronexpression='" + cronexpression + '\'' +
				", nextTime=" + nextTime +
				", previousTime=" + previousTime +
				", description='" + description + '\'' +
				", mqKey='" + mqKey + '\'' +
				'}';
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
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

	public String getJobDetailStatus() {
		return jobDetailStatus;
	}

	public void setJobDetailStatus(String jobDetailStatus) {
		this.jobDetailStatus = jobDetailStatus;
	}

	public Integer getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Integer jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getCronexpression() {
		return cronexpression;
	}

	public void setCronexpression(String cronexpression) {
		this.cronexpression = cronexpression;
	}

	public Long getNextTime() {
		return nextTime;
	}

	public void setNextTime(Long nextTime) {
		this.nextTime = nextTime;
	}

	public Long getPreviousTime() {
		return previousTime;
	}

	public void setPreviousTime(Long previousTime) {
		this.previousTime = previousTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMqKey() {
		return mqKey;
	}

	public void setMqKey(String mqKey) {
		this.mqKey = mqKey;
	}
}
