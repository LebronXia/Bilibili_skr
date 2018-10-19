package com.riane.homepage.api;

import com.riane.basiclib.base.entity.DataListResponse;
import com.riane.basiclib.base.entity.ResultObjectResponse;
import com.riane.homepage.mvp.model.entity.HomeBangumiBean;
import com.riane.homepage.mvp.model.entity.RecommentIndexBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by zhengxiaobo on 2018/9/29.
 */

public interface  HomepageService {

    /**
     * 获取首页推荐
     * @return
     */
    @GET("/x/feed/index")
    Flowable<DataListResponse<RecommentIndexBean>> getIndex(@Query("access_key") String accessKey,
                                                            @Query("actionKey") String actionkey,
                                                            @Query("ad_extra") String adExtra,
                                                            @Query("appkey") String appkey,
                                                            @Query("banner_hash") String bannerHash,
                                                            @Query("build") String build,
                                                            @Query("device") String device,
                                                            @Query("idx") int idx,
                                                            @Query("login_event") int loginEvent,
                                                            @Query("mobi_app") String mobiApp,
                                                            @Query("network") String network,
                                                            @Query("open_event") String openEvent,
                                                            @Query("platform") String platForm,
                                                            @Query("pull") boolean pull,
                                                            @Query("qn") String qn,
                                                            @Query("style") int style,
                                                            @Query("ts") String ts);


    /**
     * 获取追番数据
     * @return
     */
    @Headers("Domain-Name: bangumi")
    @GET("appindex/follow_index_page")
    Flowable<ResultObjectResponse<HomeBangumiBean>> getBangumi(@Query("appkey") String appkey,
                                                               @Query("build") String build,
                                                               @Query("mobi_app") String mobi_app,
                                                               @Query("platform") String platform,
                                                               @Query("ts") String ts);

}
