package com.riane.homepage.mvp.contract;

import com.riane.basiclib.base.entity.ResultListResponse;
import com.riane.basiclib.base.entity.ResultObjectResponse;
import com.riane.basiclib.base.mvp.IModel;
import com.riane.basiclib.base.mvp.IView;
import com.riane.homepage.mvp.model.entity.BangumiRecommendFallBean;
import com.riane.homepage.mvp.model.entity.HomeBangumiBean;
import com.riane.homepage.mvp.model.entity.Item;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by zhengxiaobo on 2018/10/17.
 */

public interface IHomeBangumiContract {
    interface View extends IView {
        void showBangumiList(List<Item> bangumiList);

        void showBangumiFallList(List<Item> bangumiFallList);

        void onLoadMoreFail();
    }

    interface Model extends IModel {
        Flowable<ResultObjectResponse<HomeBangumiBean>> getBangumiList();

        Flowable<ResultListResponse<BangumiRecommendFallBean>> getBangumiFallList(long cursor);
    }
}
