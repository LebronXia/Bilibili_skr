package com.riane.homepage.mvp.model;

import com.riane.basiclib.base.entity.DataObjectResponse;
import com.riane.basiclib.base.mvp.BaseModel;
import com.riane.basiclib.di.scope.ActivityScope;
import com.riane.basiclib.http.api.ApiHelper;
import com.riane.basiclib.integration.IRepositoryManager;
import com.riane.basiclib.utils.DateUtil;
import com.riane.homepage.api.HomepageService;
import com.riane.homepage.mvp.contract.IVideoDetailContract;
import com.riane.homepage.mvp.model.entity.VideoDetailInfo;

import javax.inject.Inject;

import io.reactivex.Flowable;
import retrofit2.http.Query;

/**
 * Created by zhengxiaobo on 2018/10/31.
 */
@ActivityScope
public class VideoDetailModel extends BaseModel implements IVideoDetailContract.Model{

    @Inject
    public VideoDetailModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Flowable<DataObjectResponse<VideoDetailInfo>> getVideoDetail(int aid) {
        return mRepositoryManager.obtainRetrofitService(HomepageService.class)
                .getVideoDetail(ApiHelper.ACCESS_KRY,
                        ApiHelper.ACTIONKEY,
                        aid,
                        ApiHelper.APP_KEY,
                        ApiHelper.BUILD,
                        ApiHelper.MOBI_APP,
                        ApiHelper.PLATFORM,
                        DateUtil.getSystemTime());
    }
}
