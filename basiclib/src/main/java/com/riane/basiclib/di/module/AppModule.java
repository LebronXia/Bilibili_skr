package com.riane.basiclib.di.module;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.riane.basiclib.integration.AppManager;
import com.riane.basiclib.integration.IRepositoryManager;
import com.riane.basiclib.integration.RepositoryManager;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger注入的基础类
 * Created by zhengxiaobo on 2018/8/19.
 */
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application){
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public Application provideApplication(){
        return mApplication;
    }

    @Singleton
    @Provides
    static Gson provideGson(Application application, @Nullable GsonConfiguration configuration) {
        GsonBuilder builder = new GsonBuilder();
        if (configuration != null)
            configuration.configGson(application, builder);
        return builder.create();
    }

    @Singleton
    @Provides
    public IRepositoryManager provideRepositoryManager(RepositoryManager repositoryManager){
        return  repositoryManager;
    }

    @Provides
    public RxPermissions provideRxPermissions(AppManager appManager) {
        return new RxPermissions(appManager.getCurrentActivity());
    }

    public interface GsonConfiguration {
        void configGson(Context context, GsonBuilder builder);
    }

}
