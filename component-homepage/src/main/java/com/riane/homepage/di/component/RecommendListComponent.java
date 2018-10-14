package com.riane.homepage.di.component;

import com.riane.basiclib.di.component.AppComponent;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.homepage.di.module.RecommendListModule;
import com.riane.homepage.mvp.ui.RecommentFragment;

import dagger.Component;

/**
 * Created by zhengxiaobo on 2018/10/8.
 */
@FragmentScope
@Component(modules = RecommendListModule.class, dependencies = AppComponent.class)
public interface RecommendListComponent {

    void inject(RecommentFragment fragment);
}
