package com.riane.basiclib.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.hss01248.dialog.StyledDialog;
import com.jaeger.library.StatusBarUtil;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.riane.basiclib.base.mvp.IView;
import com.riane.basiclib.base.widget.loadsir.EmptyCallback;
import com.riane.basiclib.base.widget.loadsir.LoadingCallback;
import com.riane.basiclib.base.widget.loadsir.RetryCallback;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.basiclib.utils.Utils;
import com.riane.basiclib.utils.constant.StatusBarConstants;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import es.dmoral.toasty.Toasty;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by zhengxiaobo on 2018/8/19.
 */

public abstract class SimpleActivity extends SupportActivity implements IView{
    //protected AppComponent
    protected AppComponent mAppComponent;
    protected Activity mContext;
    protected LoadService mLoadService;
    private Dialog mLoadingDialog;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        mContext = this;
        mAppComponent = Utils.getAppComponent();
        setStatusBar();
        if (useLoadSir()) {
            mLoadService = LoadSir.getDefault().register(registerTarget(), new Callback.OnReloadListener() {
                @Override
                public void onReload(View v) {
                    onPageRetry(v);
                }
            });
        }
        onViewCreated();
        initData();
    }

    /**
     * loadsir注册目标，默认为自身acitivity
     */
    protected Object registerTarget() {
        return this;
    }

    /**
     * 是否使用loadsir，默认不使用
     */
    protected boolean useLoadSir() {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
        this.mUnbinder = null;
        this.mAppComponent = null;
    }

    @Override
    public void showLoading() {
        mLoadingDialog = StyledDialog.buildMdLoading().show();
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            StyledDialog.dismiss(mLoadingDialog);
        }
    }

    @Override
    public void showError(String message) {
        hideLoading();
        Toasty.error(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(int stringId) {
        showError(getString(stringId));
    }

    @Override
    public void showMsg(String message) {
        Toasty.info(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMsg(int stringId) {
        showMsg(getString(stringId));
    }

    /**
     * 页面重试
     */
    protected void onPageRetry(View v) {

    }

    @Override
    public void showPageLoading() {
        if (mLoadService != null) {
            mLoadService.showCallback(LoadingCallback.class);
        }
    }

    @Override
    public void showPageEmpty() {
        if (mLoadService != null) {
            mLoadService.showCallback(EmptyCallback.class);
        }
    }

    @Override
    public void showPageError() {
        if (mLoadService != null) {
            mLoadService.showCallback(RetryCallback.class);
        }
    }

    @Override
    public void showPageContent() {
        if (mLoadService != null) {
            mLoadService.showSuccess();
        }
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(mContext,
                ContextCompat.getColor(mContext,
                        mAppComponent.statusBarAttr().get(StatusBarConstants.COLOR)),
                mAppComponent.statusBarAttr().get(StatusBarConstants.ALPHA)
        );
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();
            }
        });
    }

    protected void onViewCreated() {

    }

    protected abstract int getLayoutId();

    protected abstract void initData();
}
