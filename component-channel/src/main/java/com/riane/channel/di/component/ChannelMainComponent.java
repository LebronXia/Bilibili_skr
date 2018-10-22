package com.riane.channel.di.component;

import com.riane.basiclib.di.component.AppComponent;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.channel.di.module.ChannelMainModule;
import com.riane.channel.mvp.ui.fragment.ChannelFragment;

import dagger.Component;

/**
 * Created by zhengxiaobo on 2018/10/22.
 */
@FragmentScope
@Component(modules = ChannelMainModule.class, dependencies = AppComponent.class)
public interface ChannelMainComponent {
    void inject(ChannelFragment fragment);
}
