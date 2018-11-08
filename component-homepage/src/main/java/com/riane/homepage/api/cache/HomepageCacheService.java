package com.riane.homepage.api.cache;

import com.riane.basiclib.base.entity.ResultListResponse;
import com.riane.basiclib.base.entity.ResultObjectResponse;
import com.riane.homepage.mvp.model.entity.BangumiRecommendFallBean;
import com.riane.homepage.mvp.model.entity.HomeBangumiBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.DynamicKeyGroup;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.LifeCache;
import io.rx_cache2.ProviderKey;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by zhengxiaobo on 2018/11/7.
 */

public interface HomepageCacheService {

    /**
     * 番剧缓存数据
     * @param result
     * @param userName
     * @param evictDynamicKey
     * @return
     */
    @ProviderKey("get-Bangumi")
    @LifeCache(duration = 1, timeUnit = TimeUnit.HOURS)
    Flowable<HomeBangumiBean> getBangumi(Flowable<HomeBangumiBean> result,
                                                               DynamicKey userName, EvictDynamicKey evictDynamicKey);


    /**
     * 编辑推荐缓存数据
     * @param responseFlowable
     * @param dynamicKeyGroup
     * @param evictDynamicKey
     * @return
     */
    @ProviderKey("get-BangumiFallList")
    @LifeCache(duration = 1, timeUnit = TimeUnit.HOURS)
    Flowable<ResultObjectResponse<List<BangumiRecommendFallBean>>> getBangumiFallList(Flowable<ResultObjectResponse<List<BangumiRecommendFallBean>>> responseFlowable,
                                                                                     DynamicKeyGroup dynamicKeyGroup, EvictDynamicKey evictDynamicKey);

}
