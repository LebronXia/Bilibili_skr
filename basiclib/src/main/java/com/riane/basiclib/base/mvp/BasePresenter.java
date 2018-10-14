package com.riane.basiclib.base.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhengxiaobo on 2018/8/19.
 */

public class BasePresenter<M extends IModel, V extends IView> implements IPresenter{

    protected CompositeDisposable mCompositeDisposable;

    protected M mModel;
    protected V mView;


    public BasePresenter(M model, V rootView) {
        this.mModel = model;
        this.mView = rootView;
    }

    public BasePresenter() {
        onStart();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        unSubscribe();
        if (mModel != null){
            mModel.onDestroy();
            this.mModel = null;
        }
        this.mView = null;
    }

    protected void unSubscribe(){
        if (mCompositeDisposable != null){
            mCompositeDisposable.dispose();
        }
    }

    protected void addSubscribe(Disposable subscription){
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }


}
