package com.riane.homepage.mvp.contract;

import com.riane.basiclib.base.entity.ResultObjectResponse;
import com.riane.basiclib.base.mvp.IModel;
import com.riane.basiclib.base.mvp.IView;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by zhengxiaobo on 2018/10/17.
 */

public interface IHomeBangumiContract {
    interface View extends IView {
        void showBangumiList(List<Object> bangumiList, int refreshStatus);
    }

    interface Model extends IModel {
        Flowable<ResultObjectResponse<Object>> getBangumiList();
    }
}
