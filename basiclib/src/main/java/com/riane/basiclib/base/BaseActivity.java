package com.riane.basiclib.base;

import android.accounts.AbstractAccountAuthenticator;

import com.riane.basiclib.base.mvp.BasePresenter;
import com.riane.basiclib.di.component.AppComponent;

import javax.inject.Inject;

/**
 * Created by zhengxiaobo on 2018/8/19.
 */

public abstract class BaseActivity<P extends BasePresenter> extends SimpleActivity{

    @Inject
    protected P mPresenter;

    @Override
    protected void onViewCreated() {
        super.onViewCreated();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.onDestroy();
        }
        this.mPresenter = null;
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);

    protected abstract int getLayoutId();

    protected abstract void initData();
}
