package com.riane.homepage;

import android.widget.FrameLayout;

import com.riane.basiclib.base.SimpleActivity;
import com.riane.homepage.mvp.ui.HomePageFragment;

import butterknife.BindView;

/**
 * Created by zhengxiaobo on 2018/10/16.
 */

public class HomepageMainActivity extends SimpleActivity{

    @BindView(R.id.layout_load_fragment)
    FrameLayout mFrameLayout;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_runalone;
    }

    @Override
    protected void initData() {
        HomePageFragment homePageFragment = new HomePageFragment();
        loadRootFragment(R.id.layout_load_fragment, homePageFragment);
    }
}
