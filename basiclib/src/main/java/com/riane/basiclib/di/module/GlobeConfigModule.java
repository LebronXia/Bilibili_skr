package com.riane.basiclib.di.module;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.riane.basiclib.http.GlobeHttpHandler;
import com.riane.basiclib.http.log.DefaultFormatPrinter;
import com.riane.basiclib.http.log.FormatPrinter;
import com.riane.basiclib.http.log.RequestInterceptor;
import com.riane.basiclib.imageloader.BaseImageLoaderStrategy;
import com.riane.basiclib.imageloader.glide.GlideImageLoaderStrategy;
import com.riane.basiclib.utils.FileUtils;
import com.riane.basiclib.utils.Preconditions;
import com.riane.basiclib.utils.constant.StatusBarConstants;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * 可向框架中注入外部配置的自定义参数
 * Created by zhengxiaobo on 2018/8/25.
 */

@Module
public class GlobeConfigModule {
    private HttpUrl mApiUrl;
    //图片的处理
    private BaseImageLoaderStrategy mLoaderStrategy;
    //输出response
    private GlobeHttpHandler mHandler;
    //拦截器
    private List<Interceptor> mInterceptors;
    //缓存文件
    private File mCacheFile;
    private HashMap<String, Integer> mStatusBarAttr;
    private FormatPrinter mFormatPrinter;
    private RequestInterceptor.Level mPrintHttpLogLevel;
    private AppModule.GsonConfiguration mGsonConfiguration;
    private ClientModule.OkhttpConfiguration mOkhttpConfiguration;

    private GlobeConfigModule(Builder builder) {
        this.mApiUrl = builder.apiUrl;
        this.mHandler = builder.handler;
        this.mInterceptors = builder.interceptors;
        this.mCacheFile = builder.cacheFile;
        this.mStatusBarAttr = builder.statusBarAttr;
        this.mFormatPrinter = builder.formatPrinter;
        this.mLoaderStrategy = builder.loaderStrategy;
        this.mPrintHttpLogLevel = builder.printHttpLogLevel;
        this.mGsonConfiguration = builder.gsonConfiguration;
        this.mOkhttpConfiguration = builder.okhttpConfiguration;
    }

    public static Builder builder() {
        return new Builder();
    }


    @Singleton
    @Provides
    List<Interceptor> provideInterceptors() {
        return mInterceptors;
    }


    @Singleton
    @Provides
    HttpUrl provideBaseUrl() {
        return mApiUrl;
    }

    /**
     * 提供图片加载框架
     *
     * @return
     */
    @Singleton
    @Provides
    BaseImageLoaderStrategy provideImageLoaderStrategy() {
        return mLoaderStrategy == null ? new GlideImageLoaderStrategy() : mLoaderStrategy;
    }

    @Singleton
    @Provides
    GlobeHttpHandler provideGlobeHttpHandler() {
        return mHandler == null ? GlobeHttpHandler.EMPTY : mHandler;//打印请求信息
    }

    @Singleton
    @Provides
    ClientModule.OkhttpConfiguration provideOkhttpConfiguration() {
        return mOkhttpConfiguration;
    }

    /**
     * 提供缓存文件
     */
    @Singleton
    @Provides
    File provideCacheFile(Application application) {
        return mCacheFile == null ? FileUtils.getCacheFile(application) : mCacheFile;
    }

    /**
     * 提供系统状态栏属性值
     */
    @Singleton
    @Provides
    HashMap<String, Integer> provideStatusBarAttr() {
        return mStatusBarAttr;
    }

    @Singleton
    @Provides
    FormatPrinter provideFormatPrinter(){
        return mFormatPrinter == null ? new DefaultFormatPrinter() : mFormatPrinter;
    }

    @Singleton
    @Provides
    @Nullable
    AppModule.GsonConfiguration provideGsonConfiguration() {
        return mGsonConfiguration;
    }

    @Singleton
    @Provides
    RequestInterceptor.Level providePrintHttpLogLevel() {
        return mPrintHttpLogLevel == null ? RequestInterceptor.Level.ALL : mPrintHttpLogLevel;
    }

    public static final class Builder {

        private HttpUrl apiUrl = HttpUrl.parse("https://api.github.com/");
        private GlobeHttpHandler handler;
        private List<Interceptor> interceptors = new ArrayList<>();
        private File cacheFile;
        private HashMap<String, Integer> statusBarAttr = new HashMap<>();
        private FormatPrinter formatPrinter;
        private RequestInterceptor.Level printHttpLogLevel;
        private BaseImageLoaderStrategy loaderStrategy;
        private AppModule.GsonConfiguration gsonConfiguration;
        private ClientModule.OkhttpConfiguration okhttpConfiguration;

        private Builder() {
        }

        public Builder baseurl(String baseurl) {//基础url
            if (TextUtils.isEmpty(baseurl)) {
                throw new IllegalArgumentException("baseurl can not be empty");
            }
            this.apiUrl = HttpUrl.parse(baseurl);
            return this;
        }

        public Builder imageLoaderStrategy(BaseImageLoaderStrategy loaderStrategy) {//用来请求网络图片
            this.loaderStrategy = loaderStrategy;
            return this;
        }

        public Builder globeHttpHandler(GlobeHttpHandler handler) {//用来处理http响应结果
            this.handler = handler;
            return this;
        }

        /**
         * 提供OkHttp的配置
         * @param okhttpConfiguration
         * @return
         */
        public Builder okhttpConfiguration(ClientModule.OkhttpConfiguration okhttpConfiguration) {
            this.okhttpConfiguration = okhttpConfiguration;
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor) {//动态添加任意个interceptor
            this.interceptors.add(interceptor);
            return this;
        }


        public Builder cacheFile(File cacheFile) {
            this.cacheFile = cacheFile;
            return this;
        }

        public Builder statusBarColor(int color) {
            this.statusBarAttr.put(StatusBarConstants.COLOR, color);
            return this;
        }

        public Builder statusBarAlpha(int alpha) {
            this.statusBarAttr.put(StatusBarConstants.ALPHA, alpha);
            return this;
        }

        public GlobeConfigModule build() {
            checkNotNull(apiUrl, "baseurl is required");
            return new GlobeConfigModule(this);
        }

        public Builder printHttpLogLevel(RequestInterceptor.Level printHttpLogLevel) {//是否让框架打印 Http 的请求和响应信息
            this.printHttpLogLevel = Preconditions.checkNotNull(printHttpLogLevel, "The printHttpLogLevel can not be null, use RequestInterceptor.Level.NONE instead.");
            return this;
        }

        public Builder gsonConfiguration(AppModule.GsonConfiguration gsonConfiguration) {
            this.gsonConfiguration = gsonConfiguration;
            return this;
        }

        public Builder formatPrinter(FormatPrinter formatPrinter){
            this.formatPrinter = Preconditions.checkNotNull(formatPrinter, FormatPrinter.class.getCanonicalName() + "can not be null.");
            return this;
        }
    }

}
