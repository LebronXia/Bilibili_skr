package com.riane.homepage.mvp.contract;

import com.riane.basiclib.base.mvp.IModel;
import com.riane.basiclib.base.mvp.IView;
import com.riane.basiclib.base.entity.DataListResponse;
import com.riane.homepage.mvp.model.entity.RecommentIndexBean;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by zhengxiaobo on 2018/9/30.
 */

public interface IHomeRecommendContract {

    interface View extends IView {
        void showRecommendList(List<RecommentIndexBean> recommendList);
    }

    interface Model extends IModel {
        Flowable<DataListResponse<RecommentIndexBean>> getRecommendList(int idx, int operationState);
    }
}
