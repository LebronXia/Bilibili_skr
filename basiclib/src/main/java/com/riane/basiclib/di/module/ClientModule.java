package com.riane.basiclib.di.module;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.riane.basiclib.http.GlobeHttpHandler;
import com.riane.basiclib.http.log.RequestInterceptor;
import com.riane.basiclib.utils.FileUtils;
import com.riane.basiclib.utils.MD5Utils;
import com.riane.basiclib.utils.SignUtil;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhengxiaobo on 2018/8/24.
 */
@Module
public abstract class ClientModule {

    private static final int TIME_OUT = 30;

    /**
     * 从AppModule注入进来
     * @param builder
     * @param client
     * @param httpUrl
     * @return
     */
    @Singleton
    @Provides
    static Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client, HttpUrl httpUrl, Gson gson){
        return builder
                .baseUrl(httpUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    /**
     * 提供相对应的OKhttpClient, interceptors是由GlobeConfigModule提供
     * @param okHttpClient
     * @param interceptors
     * @return
     */
    @Singleton
    @Provides
    static OkHttpClient providerClient(Application application, OkHttpClient.Builder okHttpClient, Interceptor intercept, OkhttpConfiguration configuration, List<Interceptor> interceptors,
                                @Nullable final GlobeHttpHandler handler){
        OkHttpClient.Builder builder = okHttpClient
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(intercept);

        //打印输出配置
        if (handler != null)
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    return chain.proceed(handler.onHttpRequestBefore(chain, chain.request()));
                }
            });

        Interceptor signInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request oldRequest = chain.request();
                String sign = SignUtil.getSign(oldRequest.url());
                //添加sign参数
                HttpUrl.Builder newBuilder = oldRequest.url()
                        .newBuilder()
                        .scheme(oldRequest.url().scheme())
                        .host(oldRequest.url().host())
                        .addQueryParameter(SignUtil.PARAM_SIGN, sign);
                Request newRequest = oldRequest.newBuilder()
                        .method(oldRequest.method(), oldRequest.body())
                        .url(newBuilder.build())
                        .build();
                return chain.proceed(newRequest);
            }
        };

        //配置sign参数
        builder.addInterceptor(signInterceptor);

        //如果外部提供了interceptor的数组则遍历添加
        if (interceptors != null && interceptors.size() > 0) {
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }

        //外部配置，可动态改变Retrofit的baseUrl
        if (configuration != null){
            configuration.configOkhttp(application, builder);
        }
        return RetrofitUrlManager.getInstance().with(builder)
                .build();
    }

    @Singleton
    @Provides
    static Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    @Singleton
    @Provides
    static OkHttpClient.Builder provideClientBuilder() {
        return new OkHttpClient.Builder();
    }

    /**
     * 打印请求后的reponse
     * @param interceptor
     * @return
     */
    @Binds
    abstract Interceptor bindInterceptor(RequestInterceptor interceptor);

    /**
     * 提供RXCache客户端
     *
     * @param cacheDirectory RxCache缓存路径
     */
    @Singleton
    @Provides
    static RxCache provideRxCache(@Named("RxCacheDirectory") File cacheDirectory, Gson gson) {
        return new RxCache
                .Builder()
                .persistence(cacheDirectory, new GsonSpeaker(gson));
    }

    /**
     * 需要单独给RxCache提供缓存路径
     * 提供RxCache缓存地址
     */
    @Singleton
    @Provides
    @Named("RxCacheDirectory")
    static File provideRxCacheDirectory(File cacheDir) {
        File cacheDirectory = new File(cacheDir, "RxCache");
        return FileUtils.makeDirs(cacheDirectory);
    }

    public interface OkhttpConfiguration {
        void configOkhttp(Context context, OkHttpClient.Builder builder);
    }

}
