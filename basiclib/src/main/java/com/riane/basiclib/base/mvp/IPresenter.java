package com.riane.basiclib.base.mvp;

/**
 * Created by zhengxiaobo on 2018/8/19.
 */

public interface IPresenter {

    /**
     * 做一些初始化操作
     */
    void onStart();

    void onDestroy();
}
