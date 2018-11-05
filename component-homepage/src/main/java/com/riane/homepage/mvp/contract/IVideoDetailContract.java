package com.riane.homepage.mvp.contract;

import com.riane.basiclib.base.entity.DataObjectResponse;
import com.riane.basiclib.base.entity.ResultListResponse;
import com.riane.basiclib.base.entity.ResultObjectResponse;
import com.riane.basiclib.base.mvp.IModel;
import com.riane.basiclib.base.mvp.IView;
import com.riane.homepage.mvp.model.entity.BangumiRecommendFallBean;
import com.riane.homepage.mvp.model.entity.HomeBangumiBean;
import com.riane.homepage.mvp.model.entity.Item;
import com.riane.homepage.mvp.model.entity.VideoDetailInfo;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by zhengxiaobo on 2018/10/31.
 */

public interface IVideoDetailContract {
    interface View extends IView {
        void showVideoDetail(VideoDetailInfo videoDetail);
    }

    interface Model extends IModel {

        Flowable<DataObjectResponse<VideoDetailInfo>> getVideoDetail(int aid);
    }
}
