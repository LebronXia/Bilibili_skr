package com.riane.basiclib.base.entity;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/10/19.
 */

public class ResultListResponse<T> {
    private int code;
    private List<T> result;
    private String message;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
