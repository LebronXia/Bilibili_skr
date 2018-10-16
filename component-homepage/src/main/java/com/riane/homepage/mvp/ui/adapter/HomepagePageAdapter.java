package com.riane.homepage.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.riane.homepage.base.constant.SystemConstant;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/10/15.
 */

public class HomepagePageAdapter extends FragmentPagerAdapter{
    private List<Fragment> mFragments;

    public HomepagePageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return SystemConstant.HOMEPAGE_TAB_TITLE[position];
    }
}
