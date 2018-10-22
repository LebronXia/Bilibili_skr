package com.riane.channel.api;

import com.riane.basiclib.base.entity.DataListResponse;
import com.riane.channel.mvp.model.entity.ChannelBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhengxiaobo on 2018/10/22.
 */

public interface ChannelService {

    /**
     * 获取分区
     * http://app.bilibili.com/x/v2/region?build=503000
     * http://app.bilibili.com/x/v2/region?appkey=1d8b6e7d45233436&build=502000&mobi_app=android&platform=android&ts=1493689159000&ver=188703795824240229&sign=89ec282fcc4f06d8d3812dbc9f8456a9
     */
    @GET("/x/v2/region")
    Flowable<DataListResponse<ChannelBean>> getChannels(@Query("build") String build);

    /**
     * 获取分区列表
     * http://app.bilibili.com/x/v2/show/index?appkey=1d8b6e7d45233436&build=502000&mobi_app=android&platform=android&ts=1493711039000&sign=01cfab07e67d3520363d82636296dc8b
     */
    @GET("/x/v2/show/index")
    Flowable<DataListResponse<ChannelBean>> getChannelShow(@Query("appkey") String appkey,
                                                        @Query("build") String build,
                                                        @Query("mobi_app") String mobi_app,
                                                        @Query("platform") String platform,
                                                        @Query("ts") String ts);

}
