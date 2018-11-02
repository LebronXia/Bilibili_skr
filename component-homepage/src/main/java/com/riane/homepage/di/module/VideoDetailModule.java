package com.riane.homepage.di.module;

import com.riane.basiclib.di.scope.ActivityScope;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.homepage.mvp.contract.IHomeBangumiContract;
import com.riane.homepage.mvp.contract.IVideoDetailContract;
import com.riane.homepage.mvp.model.HomeBangumiModel;
import com.riane.homepage.mvp.model.VideoDetailModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhengxiaobo on 2018/11/1.
 */
@Module
public class VideoDetailModule {

    private IVideoDetailContract.View view;


    public VideoDetailModule(IVideoDetailContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    IVideoDetailContract.View providerVideoDetailView(){
        return this.view;
    }

    @ActivityScope
    @Provides
    IVideoDetailContract.Model providerVideoDetailModel(VideoDetailModel model){
        return model;
    }
}
