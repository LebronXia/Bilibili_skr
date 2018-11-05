package com.riane.homepage.di.component;

import com.riane.basiclib.di.component.AppComponent;
import com.riane.basiclib.di.scope.ActivityScope;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.homepage.di.module.HomeBangumiModule;
import com.riane.homepage.di.module.VideoDetailModule;
import com.riane.homepage.mvp.ui.activity.VideoDetailActivity;
import com.riane.homepage.mvp.ui.fragment.BangumiFragment;
import com.riane.homepage.mvp.ui.fragment.VideoIntroductionFragment;

import dagger.Component;

/**
 * Created by zhengxiaobo on 2018/11/1.
 */

@ActivityScope
@Component(modules = VideoDetailModule.class, dependencies = AppComponent.class)
public interface VideoDetailComponent {

    void inject(VideoDetailActivity activity);

    void inject(VideoIntroductionFragment fragment);

}
