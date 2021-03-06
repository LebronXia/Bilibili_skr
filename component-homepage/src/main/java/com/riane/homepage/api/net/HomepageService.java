package com.riane.homepage.api.net;

import com.riane.basiclib.base.entity.DataListResponse;
import com.riane.basiclib.base.entity.DataObjectResponse;
import com.riane.basiclib.base.entity.ResultListResponse;
import com.riane.basiclib.base.entity.ResultObjectResponse;
import com.riane.homepage.mvp.model.entity.BangumiRecommendFallBean;
import com.riane.homepage.mvp.model.entity.HomeBangumiBean;
import com.riane.homepage.mvp.model.entity.RecommentIndexBean;
import com.riane.homepage.mvp.model.entity.VideoDetailInfo;

import java.util.List;

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

    /**
     * 获取编辑推荐数据
     * @return
     */
    @Headers("Domain-Name: bangumi")
    @GET("/appindex/follow_index_fall")
    Flowable<ResultObjectResponse<List<BangumiRecommendFallBean>>> getBnagumiFall(@Query("appkey") String appkey,
                                                                                 @Query("build") String build,
                                                                                 @Query("cursor") long cursor,
                                                                                 @Query("mobi_app") String mobi_app,
                                                                                 @Query("platform") String platform,
                                                                                 @Query("ts") String ts);


    /**
     * 获取视屏详情页
     * @param actionKey
     * @param adExtra
     * @param aid
     * @param appkey
     * @param autoplay
     * @param build
     * @param device
     * @param from
     * @param mobi_app
     * @param platform
     * @param ts
     * @return
     */
    @GET("/x/view")
    Flowable<DataObjectResponse<VideoDetailInfo>> getVideoDetail(@Query("access_key") String accessKey,
                                                                 @Query("actionKey") String actionKey,
                                                                 @Query("aid") int aid,
                                                                 @Query("appkey") String appkey,
                                                                 @Query("build") String build,
                                                                 @Query("mobi_app") String mobi_app,
                                                                 @Query("platform") String platform,
                                                                 @Query("ts") String ts);

    //Flowable<>

}
