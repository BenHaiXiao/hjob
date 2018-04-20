package com.github.bh.hjob.core.constants;

/**
 * @author xiaobenhai
 */
public enum JobStatus {

    JOB_STATUS_ENABLE(1), JOB_STATUS_DISABLE(2);

    private final int value;

    JobStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

