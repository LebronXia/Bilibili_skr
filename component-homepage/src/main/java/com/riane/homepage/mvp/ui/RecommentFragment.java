package com.riane.homepage.mvp.ui;

import android.preference.SwitchPreference;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.homepage.R;
import com.riane.homepage.R2;
import com.riane.homepage.di.component.DaggerRecommendListComponent;
import com.riane.homepage.di.module.RecommendListModule;
import com.riane.homepage.mvp.contract.IHomeRecommendContract;
import com.riane.homepage.mvp.model.entity.RecommentIndexBean;
import com.riane.homepage.mvp.presenter.HomeRecommentPresenter;
import com.riane.homepage.mvp.ui.adapter.RecommentAdapter;
import com.riane.router.RouterConstans;

import java.util.List;

import butterknife.BindView;

/**
 * Created by zhengxiaobo on 2018/10/8.
 */
public class RecommentFragment extends BaseFragment<HomeRecommentPresenter> implements IHomeRecommendContract.View{

    @BindView(R2.id.swip_recommend_refresh)
    SwipeRefreshLayout mSwipefresh;

    @BindView(R2.id.rcv_recommend_fanju)
    RecyclerView mRcvRecommend;

    private static final int SPAN_COUNT = 2;
    private List<RecommentIndexBean> mIndexBeanList;

    private RecommentAdapter mRecommentAdapter;

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
    public void showRecommendList(List<RecommentIndexBean> recommendList) {
        if (recommendList != null){
            mIndexBeanList = recommendList;
            mRecommentAdapter = new RecommentAdapter(mIndexBeanList);
            GridLayoutManager layoutManager = new GridLayoutManager(getContext(), SPAN_COUNT);
            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    //因为在声明gridlayoutManager的时候进行了设置，so每一行2个span
                    switch (mRecommentAdapter.getItem(position).getItemType()) {
                        case RecommentIndexBean.BANNER:
                            return SPAN_COUNT;//占据两个位置的span
                        default:
                            return 1;//占据一个位置
                    }
                }
            });
            mRcvRecommend.setLayoutManager(layoutManager);
            mRcvRecommend.setAdapter(mRecommentAdapter);
        }

    }
}
