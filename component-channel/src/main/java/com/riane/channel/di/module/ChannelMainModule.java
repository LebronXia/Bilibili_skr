package com.riane.channel.di.module;

import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.channel.mvp.contract.IChannelMainContract;
import com.riane.channel.mvp.model.entity.ChannelMainModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhengxiaobo on 2018/10/22.
 */
@Module
public class ChannelMainModule {
    private IChannelMainContract.View view;


    public ChannelMainModule(IChannelMainContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    IChannelMainContract.View providerHomeBangumiView(){
        return this.view;
    }

    @FragmentScope
    @Provides
    IChannelMainContract.Model providerHomeBangumiModel(ChannelMainModel model){
        return model;
    }
}
