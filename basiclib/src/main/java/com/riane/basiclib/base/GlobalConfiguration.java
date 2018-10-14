package com.riane.basiclib.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.GsonBuilder;
import com.riane.basiclib.BuildConfig;
import com.riane.basiclib.di.module.AppModule;
import com.riane.basiclib.di.module.ClientModule;
import com.riane.basiclib.di.module.GlobeConfigModule;
import com.riane.basiclib.http.GlobalHttpHandlerImpl;
import com.riane.basiclib.http.log.RequestInterceptor;
import com.riane.basiclib.imageloader.glide.GlideImageLoaderStrategy;
import com.riane.basiclib.integration.ConfigModule;
import com.riane.basiclib.integration.IRepositoryManager;

import java.util.List;

import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import timber.log.Timber;

/**
 * baselib 的 GlobalConfiguration 含有有每个组件都可公用的配置信息, 每个组件的 AndroidManifest 都应该声明此 ConfigModule
 * Created by zhengxiaobo on 2018/10/12.
 */

public class GlobalConfiguration implements ConfigModule{
    @Override
    public void applyOptions(Context context, GlobeConfigModule.Builder builder) {

        if (BuildConfig.APP_DEBUG){
            //还需要再看在哪里注入这个打印的拦截
            builder.printHttpLogLevel(RequestInterceptor.Level.NONE);
        }
        builder.globeHttpHandler(new GlobalHttpHandlerImpl(context))
                .gsonConfiguration(new AppModule.GsonConfiguration() {
                    @Override
                    public void configGson(Context context, GsonBuilder builder) {//这里可以自己自定义配置Gson的参数
                        builder
                                .serializeNulls()//支持序列化null的参数
                                .enableComplexMapKeySerialization();//支持将序列化key为object的map,默认只能序列化key为string的map
                    }
                })
                .okhttpConfiguration(new ClientModule.OkhttpConfiguration() {
                    @Override
                    public void configOkhttp(Context context, OkHttpClient.Builder builder) {

                    }
                });

    }

    @Override
    public void registerComponents(Context context, IRepositoryManager repositoryManager) {

    }

    @Override
    public void injectAppLifecycle(Context context, List<CommonApplicationLike.Lifecycle> lifecycles) {

    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {

    }
}
