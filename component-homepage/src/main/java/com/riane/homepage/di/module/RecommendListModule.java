package com.riane.homepage.di.module;

import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.homepage.mvp.contract.IHomeRecommendContract;
import com.riane.homepage.mvp.model.HomeRecommendModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhengxiaobo on 2018/10/8.
 */

@Module
public class RecommendListModule {
    private IHomeRecommendContract.View view;


    public RecommendListModule(IHomeRecommendContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    IHomeRecommendContract.View providerHomeRecommendView(){
        return this.view;
    }

    @FragmentScope
    @Provides
    IHomeRecommendContract.Model providerHomeRecommendModel(HomeRecommendModel model){
        return model;
    }
}
