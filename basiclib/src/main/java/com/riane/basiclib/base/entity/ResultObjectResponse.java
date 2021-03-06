package com.riane.basiclib.base.entity;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/10/17.
 */

public class ResultObjectResponse<T> {
    private int code;
    private T result;
    private String message;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

