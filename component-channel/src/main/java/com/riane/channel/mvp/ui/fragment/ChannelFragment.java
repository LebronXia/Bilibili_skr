package com.riane.channel.mvp.ui.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.channel.R;
import com.riane.channel.R2;
import com.riane.channel.di.component.DaggerChannelMainComponent;
import com.riane.channel.di.module.ChannelMainModule;
import com.riane.channel.mvp.contract.IChannelMainContract;
import com.riane.channel.mvp.model.entity.ChannelBean;
import com.riane.channel.mvp.presenter.ChannelMainPresenter;
import com.riane.channel.mvp.ui.adapter.ChannelClassfifyAdapter;
import com.riane.router.RouterConstans;

import java.util.List;

import butterknife.BindView;

/**
 * Created by zhengxiaobo on 2018/10/22.
 */
@Route(path = RouterConstans.PATH_CHANNEL_MAIN)
public class ChannelFragment extends BaseFragment<ChannelMainPresenter> implements IChannelMainContract.View{

//    @BindView(R2.id.main_toolbar)
//    Toolbar mToolbar;
    @BindView(R2.id.rv_channel_classify)
    RecyclerView mRvChannelClassify;

    private ChannelClassfifyAdapter mAdapter;

    @Override
    public void setFragmentComponent(AppComponent fragmentComponent) {
        DaggerChannelMainComponent.builder()
                .appComponent(fragmentComponent)
                .channelMainModule(new ChannelMainModule(this))
                .build().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.channel_fragment_main;
    }

    @Override
    protected boolean useLoadSir() {
        return true;
    }

    @Override
    protected void initData() {
        //setToolBar(mToolbar, "频道", true,false);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        mRvChannelClassify.setLayoutManager(layoutManager);
        mRvChannelClassify.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.bg_main));
        mAdapter = new ChannelClassfifyAdapter();
        mRvChannelClassify.setAdapter(mAdapter);
        mPresenter.getChannels();
    }

    @Override
    public void showChannelClassfifies(List<ChannelBean> channelBeans) {
        mAdapter.setNewData(channelBeans);
    }
}
