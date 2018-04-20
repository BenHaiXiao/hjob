package com.github.bh.hjob.core.constants;

/**
 * @author xiaobenhai
 */
public enum JobResCode {
	SUCCESS(1), FAIL(0);

	JobResCode(int value) {
		this.value = value;
	}

	private int value;

	public int getValue() {
		return this.value;
	}
}
