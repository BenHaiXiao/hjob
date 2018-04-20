package com.github.bh.hjob.core.domain;

/**
 * @author xiaobenhai
 */
public enum  ResultCode {
    SUCCESS(0),//成功
    FAIL(1); //失败

    private final int value;

    ResultCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isSuccess(int value){
        return SUCCESS.getValue() == value;
    }
    public static boolean isFail(int value){
        return FAIL.getValue() == value;
    }
}
