package com.riane.basiclib.di.component;

import android.app.Application;

import com.google.gson.Gson;
import com.riane.basiclib.base.CommonApplicationLike;
import com.riane.basiclib.di.module.AppModule;
import com.riane.basiclib.di.module.ClientModule;
import com.riane.basiclib.di.module.GlobeConfigModule;
import com.riane.basiclib.di.module.ImageModule;
import com.riane.basiclib.imageloader.ImageLoader;
import com.riane.basiclib.integration.AppManager;
import com.riane.basiclib.integration.IRepositoryManager;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.util.HashMap;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by zhengxiaobo on 2018/8/25.
 */

@Singleton
@Component(modules = {AppModule.class, ClientModule.class, GlobeConfigModule.class})
public interface AppComponent {

    Application Appliction();

    //用于管理网络请求层，以及数据缓存层
    IRepositoryManager repositoryManager();

    OkHttpClient okHttpClient();

    //图片管理器,用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    ImageLoader imageLoder();

    //gson
    Gson gson();

    //缓存文件根目录(RxCache和Glide的的缓存都已经作为子文件夹在这个目录里),应该将所有缓存放到这个根目录里,便于管理和清理,可在GlobeConfigModule里配置
    File cacheFile();

    //用于管理所有activity
    AppManager appManager();

    RxPermissions rxPermissions();

    HashMap<String, Integer> statusBarAttr();

    void inject(CommonApplicationLike delegate);
}
