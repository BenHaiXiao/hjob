package com.github.bh.hjob.core.model;

/**
 * @author xiaobenhai
 */
public class JobTimeVo {
	private String nextTime;
	private String previousTime;

	@Override
	public String toString() {
		return "JobTimeVo{" +
				"nextTime='" + nextTime + '\'' +
				", previousTime='" + previousTime + '\'' +
				'}';
	}

	public String getNextTime() {
		return nextTime;
	}

	public void setNextTime(String nextTime) {
		this.nextTime = nextTime;
	}

	public String getPreviousTime() {
		return previousTime;
	}

	public void setPreviousTime(String previousTime) {
		this.previousTime = previousTime;
	}
}
