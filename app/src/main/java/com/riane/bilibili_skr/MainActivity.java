package com.riane.bilibili_skr;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.jaeger.library.StatusBarUtil;
import com.riane.basiclib.base.BaseActivity;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.bilibili_skr.mvp.ui.fragment.MainFragment;
import com.riane.bilibili_skr.mvp.ui.fragment.menu.FavoritesFragment;
import com.riane.bilibili_skr.mvp.ui.fragment.menu.HistoryFragment;
import com.riane.router.RouterConstans;
import com.riane.router.RouterUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.HashMap;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.mian_container)
    FrameLayout main_container;

    private MainFragment mMainFragment;
    private HistoryFragment mHistoryFragment;
    private FavoritesFragment mFavoritesFragment;
    private SupportFragment hideFragment= mMainFragment;
    private SupportFragment showFragment = mMainFragment;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        initFragments();
        loadMultipleRootFragment(R.id.mian_container,
                0,
                mMainFragment,
                mHistoryFragment,
                mFavoritesFragment
        );

        //loadRootFragment(R.id.mian_container, mMainFragment);
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    private void initFragments() {
        mMainFragment = new MainFragment();
        mHistoryFragment = HistoryFragment.newInstance();
        mFavoritesFragment = FavoritesFragment.newInstance();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()){
            case R.id.nav_home:
                showFragment = mMainFragment;
                changeFragment(item, showFragment);
                return true;
            case R.id.nav_history:
                showFragment = mHistoryFragment;
                changeFragment(item, showFragment);
                return true;
            case R.id.nav_favourite:
                showFragment = mFavoritesFragment;
                changeFragment(item, showFragment);
                return true;
        }

        return false;
    }

    private void changeFragment(MenuItem item, SupportFragment showFragment) {
        item.setChecked(true);
        showHideFragment(showFragment, hideFragment);
        hideFragment = showFragment;
    }

    @Override
    public void onBackPressedSupport() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            //exitApp();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            } else {
                //exitApp();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * DrawerLayout侧滑菜单开关
     */
    public void toggleDrawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

}
