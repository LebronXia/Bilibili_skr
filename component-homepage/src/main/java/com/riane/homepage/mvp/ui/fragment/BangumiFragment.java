package com.riane.homepage.mvp.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.homepage.R;
import com.riane.homepage.api.ApiConstants;
import com.riane.homepage.di.component.DaggerHomeBangumiComponent;
import com.riane.homepage.di.module.HomeBangumiModule;
import com.riane.homepage.mvp.contract.IHomeBangumiContract;
import com.riane.homepage.mvp.contract.IHomeRecommendContract;
import com.riane.homepage.mvp.model.HomeRecommendModel;
import com.riane.homepage.mvp.model.entity.Item;
import com.riane.homepage.mvp.model.entity.Items;
import com.riane.homepage.mvp.model.entity.RecommentIndexBean;
import com.riane.homepage.mvp.presenter.HomeBangumiPresenter;
import com.riane.homepage.mvp.ui.adapter.BangumiAdapter;
import com.riane.homepage.mvp.ui.adapter.RecommentAdapter;
import com.riane.homepage.mvp.ui.support.BangumiIntemDecoration;

import java.util.List;

import butterknife.BindView;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

/**
 * Created by zhengxiaobo on 2018/10/16.
 */

public class BangumiFragment extends BaseFragment<HomeBangumiPresenter> implements IHomeBangumiContract.View{

    @BindView(R.id.swip_bangumi_refresh)
    SwipeRefreshLayout mRefresh;
    @BindView(R.id.rv_bangumi)
    RecyclerView mRvBangumi;

    private static final int SPAN_COUNT = 3;
    private BangumiAdapter mBangumiAdapter;
    private List<Item> mItems;

    @Override
    public void setFragmentComponent(AppComponent fragmentComponent) {
        DaggerHomeBangumiComponent.builder()
                .appComponent(fragmentComponent)
                .homeBangumiModule(new HomeBangumiModule(this))
                .build().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.homepage_fragement_bangumi;
    }

    @Override
    protected boolean useLoadSir() {
        return true;
    }

    @Override
    protected void initData() {
        RetrofitUrlManager.getInstance().putDomain("bangumi", ApiConstants.BANGUMI_URL);
        mBangumiAdapter = new BangumiAdapter(mItems);
        mRvBangumi.setAdapter(mBangumiAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), SPAN_COUNT);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mBangumiAdapter.getItem(position).getItemType()) {
                    case Item.BANGUMI_RECOMMENDDETAIL:
                        return 1;//占据1个位置的span
                    default:
                        return 3;//占据3个位置
                }
            }
        });
        layoutManager.getSpanSizeLookup().setSpanIndexCacheEnabled(true);
        mRvBangumi.setLayoutManager(layoutManager);
        mRvBangumi.setNestedScrollingEnabled(false);
        mRvBangumi.addItemDecoration(new BangumiIntemDecoration());
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getBangumiData();
            }
        });
        setSwipeRefreshLayout(mRefresh);
        mPresenter.getBangumiData();
    }

    @Override
    public void showBangumiList(List<Item> bangumiList) {
        mItems = bangumiList;
        mBangumiAdapter.setNewData(mItems);

    }
}
