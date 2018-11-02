package com.riane.basiclib.base.entity;

/**
 * Created by zhengxiaobo on 2018/10/31.
 */

public class DataObjectResponse<T> {
    private int code;
    private T data;
    private String message;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
