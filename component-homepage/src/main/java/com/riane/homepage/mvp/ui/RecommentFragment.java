package com.riane.homepage.mvp.ui;

import android.preference.SwitchPreference;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.homepage.R;
import com.riane.homepage.R2;
import com.riane.homepage.di.component.DaggerRecommendListComponent;
import com.riane.homepage.di.module.RecommendListModule;
import com.riane.homepage.mvp.contract.IHomeRecommendContract;
import com.riane.homepage.mvp.presenter.HomeRecommentPresenter;
import com.riane.router.RouterConstans;

import java.util.List;

import butterknife.BindView;

/**
 * Created by zhengxiaobo on 2018/10/8.
 */
@Route(path = RouterConstans.PATH_HOMEPAGE_MAIN)
public class RecommentFragment extends BaseFragment<HomeRecommentPresenter> implements IHomeRecommendContract.View{

    @BindView(R2.id.swip_recommend_refresh)
    SwipeRefreshLayout swipefresh;

    @BindView(R2.id.rcv_recommend_fanju)
    RecyclerView rcvRecommend;

    @Override
    protected int getLayoutId() {
        return R.layout.homepage_fragment_recomment;
    }

    @Override
    public void setFragmentComponent(AppComponent fragmentComponent) {
        DaggerRecommendListComponent.builder()
                .appComponent(fragmentComponent)
                .recommendListModule(new RecommendListModule(this))
                .build().inject(this);

    }

    @Override
    protected void initData() {
        mPresenter.pullToRefresh(0);
    }

    @Override
    public void showRecommendList(List<Object> recommendList) {

    }
}
