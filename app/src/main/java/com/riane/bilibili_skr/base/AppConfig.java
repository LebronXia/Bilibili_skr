package com.riane.bilibili_skr.base;

import android.app.Application;
import android.content.Context;

import com.riane.basiclib.base.CommonApplicationLike;
import com.riane.basiclib.di.module.GlobeConfigModule;
import com.riane.basiclib.integration.ConfigModule;
import com.riane.basiclib.integration.IRepositoryManager;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/10/11.
 */

public class AppConfig implements ConfigModule{

    @Override
    public void applyOptions(Context context, GlobeConfigModule.Builder builder) {

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
