package com.riane.homepage.base;

import android.app.Application;
import android.content.Context;

import com.riane.basiclib.base.CommonApplicationLike;
import com.riane.basiclib.di.module.GlobeConfigModule;
import com.riane.basiclib.integration.ConfigModule;
import com.riane.basiclib.integration.IRepositoryManager;
import com.riane.basiclib.utils.SignUtil;
import com.riane.homepage.api.ApiConstants;
import com.riane.homepage.api.HomepageService;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhengxiaobo on 2018/10/11.
 */

public class HomepageConfig implements ConfigModule {

    @Override
    public void applyOptions(Context context, GlobeConfigModule.Builder builder) {

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
        //builder.addInterceptor(signInterceptor);
        //使用 builder 可以为框架配置一些配置信息
        builder.baseurl(ApiConstants.APP_BASE_URL)
                .addInterceptor(signInterceptor);

    }

    @Override
    public void registerComponents(Context context, IRepositoryManager repositoryManager) {
        repositoryManager.injectRetrofitService(HomepageService.class);
    }

    @Override
    public void injectAppLifecycle(Context context, List<CommonApplicationLike.Lifecycle> lifecycles) {
        //向 Application的 生命周期中注入一些自定义逻辑
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {
        //向 Activity 的生命周期中注入一些自定义逻辑
    }
}
