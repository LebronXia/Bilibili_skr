package com.riane.homepage.mvp.model;

import com.riane.basiclib.base.entity.ResultListResponse;
import com.riane.basiclib.base.entity.ResultObjectResponse;
import com.riane.basiclib.base.mvp.BaseModel;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.basiclib.integration.IRepositoryManager;
import com.riane.basiclib.utils.DateUtil;
import com.riane.basiclib.http.api.ApiHelper;
import com.riane.basiclib.utils.NetworkUtils;
import com.riane.basiclib.utils.RxUtil;
import com.riane.homepage.api.cache.HomepageCacheService;
import com.riane.homepage.api.net.HomepageService;
import com.riane.homepage.mvp.contract.IHomeBangumiContract;
import com.riane.homepage.mvp.model.entity.BangumiRecommendFallBean;
import com.riane.homepage.mvp.model.entity.HomeBangumiBean;

import org.reactivestreams.Publisher;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.DynamicKeyGroup;
import io.rx_cache2.EvictDynamicKey;

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
    public Flowable<HomeBangumiBean> getBangumiList() {
        return Flowable.just(mRepositoryManager.obtainRetrofitService(HomepageService.class)
                .getBangumi(ApiHelper.APP_KEY,
                        ApiHelper.BUILD,
                        ApiHelper.MOBI_APP,
                        ApiHelper.PLATFORM,
                        DateUtil.getSystemTime()
                )
                .compose(RxUtil.handleResultObjectResult()))
                .flatMap(bangumiFlowable ->
                        mRepositoryManager.obtainCacheService(HomepageCacheService.class)
                             .getBangumi(bangumiFlowable, new DynamicKey("bangumi"), new EvictDynamicKey(false)));

    }

    @Override
    public Flowable<ResultObjectResponse<List<BangumiRecommendFallBean>>> getBangumiFallList(int page, long cursor) {
        Flowable<ResultObjectResponse<List<BangumiRecommendFallBean>>> responseFlowable =  mRepositoryManager.obtainRetrofitService(HomepageService.class)
                .getBnagumiFall(ApiHelper.APP_KEY,
                        ApiHelper.BUILD,
                        cursor,
                        ApiHelper.MOBI_APP,
                        ApiHelper.PLATFORM,
                        DateUtil.getSystemTime())
                ;

        return mRepositoryManager.obtainCacheService(HomepageCacheService.class)
                .getBangumiFallList(responseFlowable, new DynamicKeyGroup("bangumi_falllist", page), new EvictDynamicKey(true));
    }


}
