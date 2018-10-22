package com.riane.homepage.base;

import android.app.Application;
import android.content.Context;

import com.riane.basiclib.base.CommonApplicationLike;
import com.riane.basiclib.di.module.GlobeConfigModule;
import com.riane.basiclib.integration.ConfigModule;
import com.riane.basiclib.integration.IRepositoryManager;
import com.riane.basiclib.http.api.ApiConstants;
import com.riane.homepage.api.HomepageService;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/10/11.
 */

public class HomepageConfig implements ConfigModule {

    @Override
    public void applyOptions(Context context, GlobeConfigModule.Builder builder) {

        //builder.addInterceptor(signInterceptor);
        //使用 builder 可以为框架配置一些配置信息
        builder.baseurl(ApiConstants.APP_BASE_URL);

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
