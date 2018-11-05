package com.riane.homepage.mvp.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.homepage.R;
import com.riane.basiclib.http.api.ApiConstants;
import com.riane.homepage.R2;
import com.riane.homepage.di.component.DaggerHomeBangumiComponent;
import com.riane.homepage.di.module.HomeBangumiModule;
import com.riane.homepage.mvp.contract.IHomeBangumiContract;
import com.riane.homepage.mvp.model.entity.BangumiRecommendFallBean;
import com.riane.homepage.mvp.model.entity.HomeBangumiBean;
import com.riane.homepage.mvp.model.entity.Item;
import com.riane.homepage.mvp.presenter.HomeBangumiPresenter;
import com.riane.homepage.mvp.ui.adapter.BangumiAdapter;
import com.riane.homepage.mvp.ui.support.BangumiIntemDecoration;

import java.util.List;

import butterknife.BindView;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

/**
 * Created by zhengxiaobo on 2018/10/16.
 */

public class BangumiFragment extends BaseFragment<HomeBangumiPresenter> implements IHomeBangumiContract.View{

    @BindView(R2.id.swip_bangumi_refresh)
    SwipeRefreshLayout mRefresh;
    @BindView(R2.id.rv_bangumi)
    RecyclerView mRvBangumi;

    private long cursor = 0;
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
                if (position == mBangumiAdapter.getItemCount() - 1){
                    return  3;
                } else {
                    switch (mBangumiAdapter.getItem(position).getItemType()) {

                        case Item.BANGUMI_RECOMMENDDETAIL:
                            return 1;//占据1个位置的span
                        default:
                            return 3;//占据3个位置
                    }
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
                cursor = 0;
                mPresenter.getBangumiData();
            }
        });
        mBangumiAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                int amount = mBangumiAdapter.getItemCount();
                if (cursor == 0L){
                    mPresenter.getBangumiFall(cursor);
                } else {
                    Item indexBean = mBangumiAdapter.getItem(mBangumiAdapter.getItemCount() - 2);
                    if (indexBean.getData() instanceof BangumiRecommendFallBean){
                        mPresenter.getBangumiFall(((BangumiRecommendFallBean)indexBean.getData()).getCursor());
                    } else if (indexBean.getData() instanceof HomeBangumiBean){
                        mPresenter.getBangumiFall(0);
                    }
                }
            }
        });
        setSwipeRefreshLayout(mRefresh);
        mPresenter.getBangumiData();
        //mPresenter.getBangumiFall(cursor);
    }

    @Override
    public void showBangumiList(List<Item> bangumiList) {
        mItems = bangumiList;
        mBangumiAdapter.setNewData(mItems);
        mPresenter.getBangumiFall(cursor);

    }

    @Override
    public void showBangumiFallList(List<Item> bangumiFallList) {
        if (bangumiFallList.size() == 0) {
            mBangumiAdapter.loadMoreEnd();
            return;
        }
        cursor = ((BangumiRecommendFallBean)bangumiFallList.get(bangumiFallList.size() - 1).getData()).getCursor();
        mBangumiAdapter.loadMoreComplete();
        mBangumiAdapter.addData(bangumiFallList);
    }

    @Override
    public void onLoadMoreFail() {
        mBangumiAdapter.loadMoreFail();
    }
}
