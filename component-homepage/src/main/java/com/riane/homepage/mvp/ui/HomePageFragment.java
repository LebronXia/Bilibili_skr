package com.riane.homepage.mvp.ui;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.base.SimpleFragment;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.homepage.R;
import com.riane.homepage.R2;
import com.riane.homepage.mvp.ui.adapter.HomepagePageAdapter;
import com.riane.homepage.mvp.ui.fragment.BangumiFragment;
import com.riane.router.RouterConstans;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhengxiaobo on 2018/10/14.
 */
@Route(path = RouterConstans.PATH_HOMEPAGE_MAIN)
public class HomePageFragment extends SimpleFragment{

//    @BindView(R2.id.main_toolbar)
//    Toolbar mToolbar;

    @BindView(R2.id.tablayout)
    TabLayout mTabLayout;

    @BindView(R2.id.viewpager)
    ViewPager mViewPager;

    private List<Fragment> mFragments = new ArrayList<>();
    private HomepagePageAdapter mHomepagePageAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.homepage_fragment;
    }

    @Override
    protected void initData() {
        //setToolBar(mToolbar, "", false, false);
        //setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        RecommentFragment recommentFragment = new RecommentFragment();
        mFragments.add(recommentFragment);

        BangumiFragment bangumiFragment = new BangumiFragment();
        mFragments.add(bangumiFragment);

        mHomepagePageAdapter = new HomepagePageAdapter(getChildFragmentManager(), mFragments);
        mViewPager.setAdapter(mHomepagePageAdapter);
        mViewPager.setOffscreenPageLimit(1);
        mTabLayout.setupWithViewPager(mViewPager);
    }

//    @OnClick(R2.id.toolbar_left_layout)
//    void toggleDrawer() {
//        Activity activity = getActivity();
//        if (activity instanceof MainActivity) {
//            ((MainActivity) activity).toggleDrawer();
//        }
//    }

}
