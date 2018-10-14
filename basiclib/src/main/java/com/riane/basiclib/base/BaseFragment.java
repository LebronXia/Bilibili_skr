package com.riane.basiclib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.riane.basiclib.base.mvp.BasePresenter;
import com.riane.basiclib.di.component.AppComponent;

import javax.inject.Inject;

/**
 * Created by zhengxiaobo on 2018/8/26.
 */

public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment{

    @Inject
    protected T mPresenter;
    protected View mView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setFragmentComponent(getAppComponent());
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null){
            mPresenter.onDestroy();
        }
        super.onDestroy();
    }

    public abstract void setFragmentComponent(AppComponent fragmentComponent);

    protected abstract int getLayoutId();

    protected abstract void initData();
}
