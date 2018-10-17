package com.riane.homepage.mvp.presenter;

import com.riane.basiclib.base.CommonSubscriber;
import com.riane.basiclib.base.entity.ResultObjectResponse;
import com.riane.basiclib.base.mvp.BasePresenter;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.basiclib.utils.RxUtil;
import com.riane.homepage.mvp.contract.IHomeBangumiContract;

import javax.inject.Inject;

/**
 * Created by zhengxiaobo on 2018/10/17.
 */
@FragmentScope
public class HomeBangumiPresenter extends BasePresenter<IHomeBangumiContract.Model, IHomeBangumiContract.View>{

    @Inject
    public HomeBangumiPresenter(IHomeBangumiContract.Model model, IHomeBangumiContract.View rootView) {
        super(model, rootView);
    }

    public void getBangumiData(){
        addSubscribe(mModel.getBangumiList()
                    .compose(RxUtil.<ResultObjectResponse<Object>>rxSchedulerHelper())
                    .subscribeWith(new CommonSubscriber<Object>(mView){
                        @Override
                        public void onNext(Object o) {
                            super.onNext(o);
                        }

                        @Override
                        public void onError(Throwable e) {
                            super.onError(e);
                        }

                        @Override
                        public void onComplete() {
                            super.onComplete();
                        }
                    })
                    );
    }
}
