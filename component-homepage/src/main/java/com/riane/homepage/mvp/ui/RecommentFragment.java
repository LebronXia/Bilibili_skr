package com.riane.homepage.mvp.ui;

import android.app.Activity;
import android.preference.SwitchPreference;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hss01248.dialog.StyledDialog;
import com.hss01248.dialog.interfaces.MyDialogListener;
import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.homepage.R;
import com.riane.homepage.R2;
import com.riane.homepage.di.component.DaggerRecommendListComponent;
import com.riane.homepage.di.module.RecommendListModule;
import com.riane.homepage.mvp.contract.IHomeRecommendContract;
import com.riane.homepage.mvp.model.HomeRecommendModel;
import com.riane.homepage.mvp.model.entity.RecommentIndexBean;
import com.riane.homepage.mvp.presenter.HomeRecommentPresenter;
import com.riane.homepage.mvp.ui.activity.VideoDetailActivity;
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
    protected void onPageRetry(android.view.View v) {
        mPresenter.loadData();
    }

    @Override
    protected boolean useLoadSir() {
        return true;
    }

    @Override
    protected void initData() {
        mRecommentAdapter = new RecommentAdapter(mIndexBeanList);
        mRecommentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (adapter.getItemViewType(position) == RecommentIndexBean.INDEX){
                    RecommentIndexBean item = (RecommentIndexBean) adapter.getItem(position);
                    VideoDetailActivity.startActivity((Activity) mContext, Integer.valueOf(item.getParam()), item.getCover());
                }
            }
        });

        mRcvRecommend.setAdapter(mRecommentAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), SPAN_COUNT);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mRecommentAdapter.getItem(position) == null){
                    return 2;
                }
                switch (mRecommentAdapter.getItem(position).getItemType()) {
                    case RecommentIndexBean.BANNER:
                        return 2;//占据两个位置的span
                    default:
                        return 1;//占据一个位置
                }
            }
        });
        layoutManager.getSpanSizeLookup().setSpanIndexCacheEnabled(true);
        mRcvRecommend.setLayoutManager(layoutManager);
        mRcvRecommend.setNestedScrollingEnabled(false);
        mRecommentAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                int amount = mRecommentAdapter.getItemCount();
                RecommentIndexBean indexBean = mRecommentAdapter.getItem(mRecommentAdapter.getItemCount() - 2);
                mPresenter.loadMore(indexBean.getIdx() - 1);
            }
        });
        mSwipefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullToRefresh();
            }
        });
        setSwipeRefreshLayout(mSwipefresh);
        mPresenter.loadData();
    }

    private void pullToRefresh(){
        if (mIndexBeanList == null || mIndexBeanList.size() == 0){
            mPresenter.loadData();
        }
        int idx = mIndexBeanList.get(0).getIdx() + 1;
        mPresenter.pullToRefresh(idx);
    }

    private void showTextLoading() {
        StyledDialog.buildIosAlert("title", "啊哈哈哈哈哈哈哈哈",new MyDialogListener(){
            @Override
            public void onThird() {
                super.onThird();
            }

            @Override
            public void onFirst() {
                StyledDialog.dismissLoading();
            }

            @Override
            public void onSecond() {

            }
        }).setBtnSize(14)
                .setBtnText("再考虑一下", "取消", "确定")
                .show();
    }

    @Override
    public void showRecommendList(List<RecommentIndexBean> recommendList, int refreshStatus) {
        if (mSwipefresh.isRefreshing()) {
            mSwipefresh.setRefreshing(false);
        }
        mIndexBeanList = recommendList;
        switch (refreshStatus){
            case HomeRecommendModel.STATE_INITIAL:
                mRecommentAdapter.setNewData(mIndexBeanList);
                break;
            case HomeRecommendModel.STATE_REFRESHING:
                mRecommentAdapter.setNewData(mIndexBeanList);
                break;
            case HomeRecommendModel.STATE_LOAD_MORE:
                mRecommentAdapter.addData(mIndexBeanList);
                mRecommentAdapter.loadMoreComplete();
                break;
        }

        //showTextLoading();

    }


    @Override
    public void showError(int stringId) {
        if (mSwipefresh.isRefreshing()) {
            mSwipefresh.setRefreshing(false);
        }
        super.showError(stringId);
    }
}
