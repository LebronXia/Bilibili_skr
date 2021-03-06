package com.riane.homepage.mvp.presenter;

import com.riane.basiclib.base.CommonSubscriber;
import com.riane.basiclib.base.entity.ResultListResponse;
import com.riane.basiclib.base.entity.ResultObjectResponse;
import com.riane.basiclib.base.mvp.BasePresenter;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.basiclib.utils.RxUtil;
import com.riane.homepage.mvp.contract.IHomeBangumiContract;
import com.riane.homepage.mvp.model.entity.BangumiRecommendFallBean;
import com.riane.homepage.mvp.model.entity.HomeBangumiBean;
import com.riane.homepage.mvp.model.entity.Item;
import com.riane.homepage.mvp.model.entity.Items;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

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
                    .compose(RxUtil.<HomeBangumiBean>rxSchedulerHelper())
                    .map(new Function<HomeBangumiBean,  List<Item>>() {
                        @Override
                        public  List<Item> apply(HomeBangumiBean homeBangumiBean) throws Exception {
                           List<Item> items = new ArrayList<>();
                           items.add(new Item(Item.BANGUMI_TOPHOME, null));
                           items.add(new Item(Item.BANGUMI_RECOMMENDHEAD, "番剧推荐"));
                           for (HomeBangumiBean.RecommendBean recommendBean : homeBangumiBean.getRecommend_jp().getRecommend()){
                               items.add(new Item(Item.BANGUMI_RECOMMENDDETAIL, recommendBean));
                           }
                           items.add(new Item(Item.BANGUMI_RECOMMENDFOOT, null));
                            items.add(new Item(Item.BANGUMI_RECOMMENDHEAD, "国产动画推荐"));
                            for (HomeBangumiBean.RecommendBean recommendBean : homeBangumiBean.getRecommend_cn().getRecommend()){
                                items.add(new Item(Item.BANGUMI_RECOMMENDDETAIL, recommendBean));
                            }
                            items.add(new Item(Item.BANGUMI_RECOMMENDFOOT, null));
                            return items;
                        }
                    })
                    .subscribeWith(new CommonSubscriber<List<Item>>(mView){
                        @Override
                        public void onNext( List<Item> items) {
                            super.onNext(items);
                            mView.showBangumiList(items);
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
                        }
                    })
                    );
    }

    public void getBangumiFall(int page, final long cursor){
        addSubscribe(mModel.getBangumiFallList(page, cursor)
                .compose(RxUtil.<ResultObjectResponse<List<BangumiRecommendFallBean>>>rxSchedulerHelper())
                .map(new Function<ResultObjectResponse<List<BangumiRecommendFallBean>>, List<Item>>() {

                    @Override
                    public List<Item> apply(ResultObjectResponse<List<BangumiRecommendFallBean>> bangumiRecommendFallBeanResultListResponse) throws Exception {
                        List<Item> items = new ArrayList<>();
                        if (cursor == 0L){
                            items.add(new Item(Item.BANGUMI_RECOMMENDHEAD, "编辑推荐"));
                        }
                        for (BangumiRecommendFallBean bangumiRecommendFallBean: bangumiRecommendFallBeanResultListResponse.getResult()){
                            items.add(new Item(Item.BANGUMI_INDEX_FALL, bangumiRecommendFallBean));
                        }
                        return items;
                    }
                })
                .subscribeWith(new CommonSubscriber<List<Item>>(mView){
                    @Override
                    public void onNext(List<Item> bangumiRecommendFallBeans) {
                        super.onNext(bangumiRecommendFallBeans);
                        mView.showBangumiFallList(bangumiRecommendFallBeans);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.onLoadMoreFail();
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                })
                
        );
        
    }


}
