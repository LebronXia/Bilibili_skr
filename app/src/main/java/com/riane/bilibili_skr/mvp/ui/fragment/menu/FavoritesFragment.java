package com.riane.bilibili_skr.mvp.ui.fragment.menu;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.base.SimpleFragment;
import com.riane.basiclib.base.widget.loadsir.EmptyFaviourCallback;
import com.riane.basiclib.base.widget.loadsir.EmptyHistoryCallback;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.bilibili_skr.MainActivity;
import com.riane.bilibili_skr.R;

import butterknife.BindView;

/**
 * Created by zhengxiaobo on 2018/11/8.
 */

public class FavoritesFragment extends SimpleFragment{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    //@BindView(R.id.layout_content)
    RelativeLayout layoutContent;

    public static FavoritesFragment newInstance() {
        return new FavoritesFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_empty;
    }

    @Override
    protected boolean useLoadSir() {
        return true;
    }

    @Override
    protected boolean keepTitle() {
        return true;
    }

    @Override
    protected void initData() {
        showPageEmpty();
        mToolbar.setTitle("我的收藏");
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_navigation_drawer);
        mToolbar.setNavigationOnClickListener(v -> {
            Activity activity1 = getActivity();
            if (activity1 instanceof MainActivity) {
                ((MainActivity) activity1).toggleDrawer();
            }
        });
    }

    @Override
    protected Object registerTarget() {
        layoutContent = mView.findViewById(R.id.layout_content);
        return layoutContent;
    }

    @Override
    public void showPageEmpty() {
        if (mLoadService != null) {
            mLoadService.showCallback(EmptyFaviourCallback.class);
        }
    }
}
