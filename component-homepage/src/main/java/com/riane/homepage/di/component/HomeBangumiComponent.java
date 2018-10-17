package com.riane.homepage.di.component;

import com.riane.basiclib.di.component.AppComponent;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.homepage.di.module.HomeBangumiModule;
import com.riane.homepage.mvp.ui.RecommentFragment;
import com.riane.homepage.mvp.ui.fragment.BangumiFragment;

import dagger.Component;

/**
 * Created by zhengxiaobo on 2018/10/17.
 */
@FragmentScope
@Component(modules = HomeBangumiModule.class, dependencies = AppComponent.class)
public interface HomeBangumiComponent {
    void inject(BangumiFragment fragment);
}
