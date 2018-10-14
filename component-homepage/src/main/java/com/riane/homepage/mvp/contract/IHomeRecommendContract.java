package com.riane.homepage.mvp.contract;

import com.riane.basiclib.base.mvp.IModel;
import com.riane.basiclib.base.mvp.IView;
import com.riane.homepage.mvp.model.entity.DataListResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by zhengxiaobo on 2018/9/30.
 */

public interface IHomeRecommendContract {

    interface View extends IView {
        void showRecommendList(List<Object> recommendList);
    }

    interface Model extends IModel {
        Flowable<DataListResponse<Object>> getRecommendList(int idx, int operationState);
    }
}
