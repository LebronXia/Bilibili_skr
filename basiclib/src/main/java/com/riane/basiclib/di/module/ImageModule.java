package com.riane.basiclib.di.module;

import com.riane.basiclib.imageloader.BaseImageLoaderStrategy;
import com.riane.basiclib.imageloader.glide.GlideImageLoaderStrategy;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhengxiaobo on 2018/8/25.
 */

@Module
public class ImageModule {

    @Singleton
    @Provides
    public BaseImageLoaderStrategy provideImageLoaderStrategy(GlideImageLoaderStrategy glideImageLoaderStrategy){
        return glideImageLoaderStrategy;
    }
}
