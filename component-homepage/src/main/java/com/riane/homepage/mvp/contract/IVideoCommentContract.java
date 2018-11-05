package com.riane.homepage.mvp.contract;

import com.riane.basiclib.base.entity.DataObjectResponse;
import com.riane.basiclib.base.mvp.IModel;
import com.riane.basiclib.base.mvp.IView;
import com.riane.homepage.mvp.model.entity.VideoDetailInfo;

import io.reactivex.Flowable;

/**
 * Created by zhengxiaobo on 2018/11/2.
 */

public interface IVideoCommentContract {

    interface View extends IView {
        void showVideoComments(Object videoDetail);
    }

    interface Model extends IModel {

        Flowable<DataObjectResponse<Object>> getVideoComments();
    }
}
