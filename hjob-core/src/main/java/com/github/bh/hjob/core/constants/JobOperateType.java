package com.github.bh.hjob.core.constants;

/**
 * @author xiaobenhai
 */
public enum JobOperateType {
	PAUSE(0), RESUME(1);

	private int value;

	JobOperateType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
