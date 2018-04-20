package com.github.bh.hjob.core.model;


/**
 * @author xiaobenhai
 */
public class ResponseData<T> {

    public boolean success;

    public Integer code;

    public String msg;

    public T data;



    public boolean isSuccess() {
        return success;
    }

    public ResponseData<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public ResponseData<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseData<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseData<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }


    public static <T> ResponseData<T> success(T data) {
        ResponseData<T> apiRspData = new ResponseData<T>();
        apiRspData.setData(data);
        apiRspData.setSuccess(true);

        return apiRspData;
    }

    public static <T> ResponseData<T> fail(Integer code, String message) {
        ResponseData<T> apiRspData = new ResponseData<T>();
        apiRspData.setCode(code);
        apiRspData.setMsg(message);
        apiRspData.setSuccess(false);
        return apiRspData;
    }

}
