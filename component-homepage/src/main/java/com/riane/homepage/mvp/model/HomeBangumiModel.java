package com.riane.homepage.mvp.model;

import com.riane.basiclib.base.entity.ResultObjectResponse;
import com.riane.basiclib.base.mvp.BaseModel;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.basiclib.integration.IRepositoryManager;
import com.riane.basiclib.utils.DateUtil;
import com.riane.homepage.api.ApiHelper;
import com.riane.homepage.api.HomepageService;
import com.riane.homepage.mvp.contract.IHomeBangumiContract;
import com.riane.homepage.mvp.model.entity.HomeBangumiBean;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by zhengxiaobo on 2018/10/17.
 */
@FragmentScope
public class HomeBangumiModel extends BaseModel implements IHomeBangumiContract.Model{
    @Inject
    public HomeBangumiModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Flowable<ResultObjectResponse<HomeBangumiBean>> getBangumiList() {
        return mRepositoryManager.obtainRetrofitService(HomepageService.class)
                .getBangumi(ApiHelper.APP_KEY,
                            ApiHelper.BUILD,
                            ApiHelper.MOBI_APP,
                            ApiHelper.PLATFORM,
                            DateUtil.getSystemTime()
                        );
    }
}
