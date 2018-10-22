package com.riane.bilibili_skr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.jaeger.library.StatusBarUtil;
import com.riane.basiclib.base.BaseActivity;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.router.RouterConstans;
import com.riane.router.RouterUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.HashMap;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.view_enterance_bar)
    BottomBar bottomBar;
    @BindView(R.id.gl_contentContainer)
    FrameLayout mianContent;

    //存放Fragemnt
    HashMap<String, Class<? extends SupportFragment>> loadFragments = new HashMap<>();
    private String hideFragment= RouterConstans.PATH_HOMEPAGE_MAIN;
    private String showFragment = RouterConstans.PATH_HOMEPAGE_MAIN;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        if (loadFragments.get(RouterConstans.PATH_HOMEPAGE_MAIN) == null){
            loadMultipleRootFragment(R.id.gl_contentContainer,
                    0,
                    getTargetFragment(RouterConstans.PATH_HOMEPAGE_MAIN),
                    getTargetFragment(RouterConstans.PATH_CHANNEL),
                    getTargetFragment(RouterConstans.PATH_HOMEPAGE_MAIN),
                    getTargetFragment(RouterConstans.PATH_HOMEPAGE_MAIN));

        }

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId){
                    case R.id.nav_home:
                        showFragment = RouterConstans.PATH_HOMEPAGE_MAIN;
                        break;
                    case R.id.nav_category:
                        showFragment = RouterConstans.PATH_CHANNEL;
                        break;
                }
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
}
