package com.riane.homepage.mvp.presenter;

import com.riane.basiclib.base.CommonSubscriber;
import com.riane.basiclib.base.mvp.BasePresenter;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.basiclib.utils.RxUtil;
import com.riane.homepage.mvp.contract.IHomeRecommendContract;
import com.riane.homepage.mvp.model.HomeRecommendModel;
import com.riane.homepage.mvp.model.entity.DataListResponse;

import javax.inject.Inject;

/**
 * Created by zhengxiaobo on 2018/9/30.
 */
@FragmentScope
public class HomeRecommentPresenter extends BasePresenter<IHomeRecommendContract.Model, IHomeRecommendContract.View>{

    private int state;

    @Inject
    public HomeRecommentPresenter(IHomeRecommendContract.Model model, IHomeRecommendContract.View rootView) {
        super(model, rootView);
    }


    public void loadData(){
        state = HomeRecommendModel.STATE_INITIAL;
        getRecommmetnList(0, state);
    }

    public void pullToRefresh(int idx){
        if (state == HomeRecommendModel.STATE_REFRESHING){
            return;
        }
        state = HomeRecommendModel.STATE_REFRESHING;
        getRecommmetnList(idx, state);
    }

    public void loadMore(int idx){
        if (state == HomeRecommendModel.STATE_LOAD_MORE){
            return;
        }
        state = HomeRecommendModel.STATE_LOAD_MORE;
        getRecommmetnList(idx, state);
    }

    private void getRecommmetnList(int idx, int operationState){
        addSubscribe(
                mModel.getRecommendList(idx, operationState)
                .compose(RxUtil.<DataListResponse<Object>>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<Object>(mView){
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.showPageError();
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                })
        );
    }
}
