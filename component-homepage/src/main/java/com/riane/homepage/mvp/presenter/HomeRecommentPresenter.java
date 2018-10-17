package com.riane.homepage.mvp.presenter;

import com.riane.basiclib.base.CommonSubscriber;
import com.riane.basiclib.base.mvp.BasePresenter;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.basiclib.utils.RxUtil;
import com.riane.homepage.mvp.contract.IHomeRecommendContract;
import com.riane.homepage.mvp.model.HomeRecommendModel;
import com.riane.basiclib.base.entity.DataListResponse;
import com.riane.homepage.mvp.model.entity.RecommentIndexBean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

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

    /**
     * 首次获取数据
     * @param
     */
    public void loadData(){
        state = HomeRecommendModel.STATE_INITIAL;
        getRecommmetnList(0, state);
    }

    /**
     * 刷新
     * @param idx
     */
    public void pullToRefresh(int idx){
        if (state == HomeRecommendModel.STATE_REFRESHING){
            return;
        }
        state = HomeRecommendModel.STATE_REFRESHING;
        getRecommmetnList(idx, state);
    }

    /**
     * 下拉加载
     * @param idx
     */
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
                .compose(RxUtil.<DataListResponse<RecommentIndexBean>>rxSchedulerHelper())
                        .map(new Function<DataListResponse<RecommentIndexBean>, List<RecommentIndexBean>>() {
                            @Override
                            public List<RecommentIndexBean> apply(DataListResponse<RecommentIndexBean> recommentIndexBeanDataListResponse) throws Exception {
                                List<RecommentIndexBean> list = new ArrayList<>();
                                for (RecommentIndexBean indexBean : recommentIndexBeanDataListResponse.getData()){
                                    if (indexBean.getGotoX().equals("banner")){
                                        indexBean.setType(RecommentIndexBean.BANNER);
                                    } else {
                                        indexBean.setType(RecommentIndexBean.INDEX);
                                    }
                                    list.add(indexBean);
                                }
                                return list;
                            }
                        })
                .subscribeWith(new CommonSubscriber<List<RecommentIndexBean>>(mView){
                    @Override
                    public void onNext(List<RecommentIndexBean> o) {
                        super.onNext(o);
                        mView.showRecommendList(o, state);
                        mView.showPageContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.showPageError();
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        mView.hideLoading();
                        state = HomeRecommendModel.STATE_NORMAL;
                    }
                })
        );
    }
}
