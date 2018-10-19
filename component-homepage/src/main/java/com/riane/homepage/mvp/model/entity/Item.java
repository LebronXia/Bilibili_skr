package com.riane.homepage.mvp.model.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by zhengxiaobo on 2018/10/17.
 */

public class Item implements MultiItemEntity{
    public static final int BANGUMI_TOPHOME= 1;
    public static final int BANGUMI_RECOMMENDHEAD = 2;
    public static final int BANGUMI_RECOMMENDDETAIL = 3;
    public static final int BANGUMI_RECOMMENDFOOT = 4;
    public static final int BANGUMI_INDEX_FALL = 5;
    public static final int BANGUMI_DIVIDER = 6;


    private int type;
    private Object data;

    public Item(int type, Object data) {
        this.type = type;
        this.data = data;
    }

    public Item() {
    }

    @Override
    public int getItemType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
