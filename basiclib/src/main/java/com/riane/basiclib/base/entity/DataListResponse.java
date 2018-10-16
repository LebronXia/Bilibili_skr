package com.riane.basiclib.base.entity;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/9/30.
 */

public class DataListResponse<T> {
    private int code;
    private List<T> data;
    private String message;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
