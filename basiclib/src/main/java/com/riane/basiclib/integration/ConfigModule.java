package com.riane.basiclib.integration;

import android.app.Application;
import android.content.Context;


import com.riane.basiclib.base.CommonApplicationLike;
import com.riane.basiclib.di.module.GlobeConfigModule;

import java.util.List;

/**
 *
 * 此接口可以给框架配置一些参数,需要实现类实现后,并在AndroidManifest中声明该实现类
 * Created by zhengxiaobo on 2018/8/19.
 */

public interface ConfigModule {
    /**
     * 使用{@link GlobeConfigModule.Builder}给框架配置一些配置参数
     */
    void applyOptions(Context context, GlobeConfigModule.Builder builder);

    /**
     * 使用{@link IRepositoryManager}给框架注入一些网络请求和数据缓存等服务
     */
    void registerComponents(Context context, IRepositoryManager repositoryManager);

    /**
     * 使用{@link CommonApplicationLike.Lifecycle}在Application的声明周期中注入一些操作
     */
    void injectAppLifecycle(Context context, List<CommonApplicationLike.Lifecycle> lifecycles);

    /**
     * 使用{@link Application.ActivityLifecycleCallbacks}在Activity的生命周期中注入一些操作
     */
    void injectActivityLifecycle(Context context,
                                 List<Application.ActivityLifecycleCallbacks> lifecycles);
}
