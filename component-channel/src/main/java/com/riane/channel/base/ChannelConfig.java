package com.riane.channel.base;

import android.app.Application;
import android.content.Context;

import com.riane.basiclib.base.CommonApplicationLike;
import com.riane.basiclib.di.module.GlobeConfigModule;
import com.riane.basiclib.integration.ConfigModule;
import com.riane.basiclib.integration.IRepositoryManager;
import com.riane.channel.api.ApiConstant;
import com.riane.channel.api.ChannelService;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/10/22.
 */

public class ChannelConfig implements ConfigModule{

    @Override
    public void applyOptions(Context context, GlobeConfigModule.Builder builder) {
        builder.baseurl(ApiConstant.APP_BASE_URL);
    }

    @Override
    public void registerComponents(Context context, IRepositoryManager repositoryManager) {
        repositoryManager.injectRetrofitService(ChannelService.class);
    }

    @Override
    public void injectAppLifecycle(Context context, List<CommonApplicationLike.Lifecycle> lifecycles) {

    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {

    }
}
