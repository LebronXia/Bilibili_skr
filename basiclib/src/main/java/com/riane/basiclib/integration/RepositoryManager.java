package com.riane.basiclib.integration;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.rx_cache2.internal.RxCache;
import retrofit2.Retrofit;

/**
 * 用来管理网络请求层，以及数据缓存层，以后可以
 * Created by zhengxiaobo on 2018/8/19.
 */
@Singleton
public class RepositoryManager implements IRepositoryManager {

    private final Map<String, Object> mRetrofitServiceCache = new LinkedHashMap<>();
    private final Map<String, Object> mCacheServiceCache = new LinkedHashMap<>();
    //private final Map<String, RealmConfiguration> mRealmConfigs = new LinkedHashMap<>();
    private Retrofit mRetrofit;
    private RxCache mRxCache;

    @Inject
    public RepositoryManager(Retrofit retrofit, RxCache rxCache){
        this.mRetrofit = retrofit;
        this.mRxCache = rxCache;
    }

    /**
     * 注入RetrofitService,在{@link ConfigModule#registerComponents(Context, IRepositoryManager)}中进行注入
     */
    @Override
    public void injectRetrofitService(Class<?>[] services) {
        for (Class<?> service : services) {
            if (mRetrofitServiceCache.containsKey(service.getName())) {
                continue;
            }
            mRetrofitServiceCache.put(service.getName(), mRetrofit.create(service));
        }
    }

    /**
     * 注入CacheService,在{@link ConfigModule#registerComponents(Context, IRepositoryManager)}中进行注入
     */
    @Override
    public void injectCacheService(Class<?>[] services) {
        for (Class<?> service : services) {
            if (mCacheServiceCache.containsKey(service.getName())) {
                continue;
            }
            mCacheServiceCache.put(service.getName(), mRxCache.using(service));
        }
    }
//
//    @Override
//    public void injectRealmConfigs(RealmConfiguration... realmConfigurations) {
//
//    }

    /**
     * 根据传入的Class获取对应的Retrift service
     */
    @Override
    public <T> T obtainRetrofitService(Class<T> service) {
        return (T) mRetrofitServiceCache.get(service.getName());
    }

    /**
     * 根据传入的Class获取对应的RxCache service
     */
    @Override
    public <T> T obtainCacheService(Class<T> cache) {
        return (T) mCacheServiceCache.get(cache.getName());
    }
}
