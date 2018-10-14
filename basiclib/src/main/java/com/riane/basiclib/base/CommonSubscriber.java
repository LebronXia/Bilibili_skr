package com.riane.basiclib.base;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.riane.basiclib.R;
import com.riane.basiclib.base.mvp.IView;
import com.riane.basiclib.http.ApiException;

import java.net.SocketTimeoutException;

import es.dmoral.toasty.Toasty;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * 对网络请求的失败请求的处理进行封装
 * Created by zhengxiaobo on 2018/9/30.
 */

public class CommonSubscriber<T> extends ResourceSubscriber<T>{

    private Context mContext;
    private IView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    protected CommonSubscriber(Context context) {
        this.mContext = context;
    }

    protected CommonSubscriber(IView view) {
        this.mView = view;
    }

    protected CommonSubscriber(IView view, String errorMsg) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(IView view, boolean isShowErrorState) {
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(IView view, String errorMsg, boolean isShowErrorState) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (mView == null && mContext == null) {
            return;
        }
        showError(e);
    }

    private void showError(Throwable e) {
        if (mView != null) {
            if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
                mView.showError(mErrorMsg);
            } else if (e instanceof ApiException) {
                mView.showError(e.toString());
            } else if (e instanceof HttpException) {
                if (((HttpException) e).code() == 429) {
                    mView.showError(R.string.msg_error_too_fast);
                } else {
                    mView.showError(R.string.msg_error_network);
                }
            } else if (e instanceof SocketTimeoutException) {
                mView.showError(R.string.msg_error_network);
            } else {
                mView.showError(R.string.msg_error_unknown);
            }
        } else if (mContext != null) {
            if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
                Toasty.error(mContext, mErrorMsg, Toast.LENGTH_SHORT).show();
            } else if (e instanceof ApiException) {
                Toasty.error(mContext, e.toString(), Toast.LENGTH_SHORT).show();
            } else if (e instanceof HttpException) {
                int resString = R.string.msg_error_network;
                if (((HttpException) e).code() == 429) {
                    resString = R.string.msg_error_too_fast;
                }
                Toasty.error(
                        mContext,
                        mContext.getString(resString),
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }

    @Override
    public void onComplete() {

    }
    
    
}
