package com.riane.homepage.di.module;

import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.homepage.mvp.contract.IHomeBangumiContract;
import com.riane.homepage.mvp.model.HomeBangumiModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhengxiaobo on 2018/10/17.
 */
@Module
public class HomeBangumiModule {
    private IHomeBangumiContract.View view;


    public HomeBangumiModule(IHomeBangumiContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    IHomeBangumiContract.View providerHomeBangumiView(){
        return this.view;
    }

    @FragmentScope
    @Provides
    IHomeBangumiContract.Model providerHomeBangumiModel(HomeBangumiModel model){
        return model;
    }
}
