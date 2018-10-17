package com.riane.homepage.mvp.ui.fragment;

import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.homepage.R;
import com.riane.homepage.api.ApiConstants;
import com.riane.homepage.di.component.DaggerHomeBangumiComponent;
import com.riane.homepage.di.module.HomeBangumiModule;
import com.riane.homepage.mvp.contract.IHomeBangumiContract;
import com.riane.homepage.mvp.contract.IHomeRecommendContract;
import com.riane.homepage.mvp.presenter.HomeBangumiPresenter;

import java.util.List;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

/**
 * Created by zhengxiaobo on 2018/10/16.
 */

public class BangumiFragment extends BaseFragment<HomeBangumiPresenter> implements IHomeBangumiContract.View{

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
        mPresenter.getBangumiData();
    }

    @Override
    public void showBangumiList(List<Object> bangumiList, int refreshStatus) {

    }
}
