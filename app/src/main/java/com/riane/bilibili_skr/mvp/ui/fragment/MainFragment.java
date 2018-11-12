package com.riane.bilibili_skr.mvp.ui.fragment;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.riane.basiclib.base.SimpleFragment;
import com.riane.basiclib.base.widget.AlwaysCenterTextView;
import com.riane.bilibili_skr.MainActivity;
import com.riane.bilibili_skr.R;
import com.riane.router.RouterConstans;
import com.riane.router.RouterUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by zhengxiaobo on 2018/10/23.
 */
public class MainFragment extends SimpleFragment{

    @BindView(R.id.main_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.view_enterance_bar)
    BottomBar bottomBar;
    @BindView(R.id.fl_contentContainer)
    FrameLayout mianContent;
    @BindView(R.id.tv_title)
    AlwaysCenterTextView mCenterTextView;

    //存放Fragemnt
    HashMap<String, Class<? extends SupportFragment>> loadFragments = new HashMap<>();
    private String hideFragment= RouterConstans.PATH_HOMEPAGE_MAIN;
    private String showFragment = RouterConstans.PATH_HOMEPAGE_MAIN;
    private int index;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mian;
    }

    @Override
    protected void initData() {

        setToolBar(mToolbar, "");
        setHasOptionsMenu(true);
        if (loadFragments.get(RouterConstans.PATH_HOMEPAGE_MAIN) == null){
            ((MainActivity)getActivity()).loadMultipleRootFragment(R.id.fl_contentContainer,
                    0,
                    getTargetFragment(RouterConstans.PATH_HOMEPAGE_MAIN),
                    getTargetFragment(RouterConstans.PATH_CHANNEL_MAIN));
        }

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId){
                    case R.id.nav_home:
                        index = 0;
                        showFragment = RouterConstans.PATH_HOMEPAGE_MAIN;
                        mCenterTextView.setText("");
                        getActivity().invalidateOptionsMenu();
                        break;
                    case R.id.nav_category:
                        index = 1;
                        showFragment = RouterConstans.PATH_CHANNEL_MAIN;
                        mCenterTextView.setText("分区");
                        getActivity().invalidateOptionsMenu();
                        break;
                }

//                getChildFragmentManager().beginTransaction()
//                        .show(getTargetFragment(showFragment))
//                        .hide(getTargetFragment(hideFragment))
//                        .commit();
                showHideFragment(getTargetFragment(showFragment),
                        getTargetFragment(hideFragment));
                hideFragment = showFragment;
            }
        });
    }

    /**
     * 根据定义的router地址取出相对应的Fragment
     * @param path
     * @return
     */
    private SupportFragment getTargetFragment(String path){
        //获取栈内Fragment对象
        if (loadFragments.get(path) != null && findFragment(loadFragments.get(path)) != null){
            return findFragment(loadFragments.get(path));
        } else {
            SupportFragment fragment = (SupportFragment) (RouterUtils.getInstance().build(path).navigation());
            if (fragment == null){
                showMsg("空页面");
            }
            loadFragments.put(path, fragment.getClass());
            return fragment;
        }
    }

    @OnClick(R.id.toolbar_left_layout)
    void toggleDrawer() {
        Activity activity = getActivity();
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).toggleDrawer();
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(com.riane.homepage.R.menu.homepage_main, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem game = menu.findItem(R.id.action_game_center);
        MenuItem download = menu.findItem(R.id.action_download);
        MenuItem search = menu.findItem(R.id.action_search);
        switch (index){
            case 0:
                game.setVisible(true);
                download.setVisible(true);
                search.setVisible(true);
                break;
            case 1:
                game.setVisible(false);
                download.setVisible(true);
                search.setVisible(true);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == com.riane.homepage.R.id.action_game_center) {
            //TODO
            showMsg("游戏中心");

        } else if (id == com.riane.homepage.R.id.action_download) {//TODO

        } else if (id == com.riane.homepage.R.id.action_search) {//TODO

        }
        return super.onOptionsItemSelected(item);
    }
}
