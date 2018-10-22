package com.riane.homepage.mvp.ui;

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

/**
 * Created by zhengxiaobo on 2018/10/14.
 */
@Route(path = RouterConstans.PATH_HOMEPAGE_MAIN)
public class HomePageFragment extends SimpleFragment{

    @BindView(R2.id.main_toolbar)
    Toolbar mToolbar;

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
        setToolBar(mToolbar, "", false, false);
        setHasOptionsMenu(true);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.homepage_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_game_center) {
            //TODO
            showMsg("游戏中心");

        } else if (id == R.id.action_download) {//TODO

        } else if (id == R.id.action_search) {//TODO

        }
        return super.onOptionsItemSelected(item);
    }
}
