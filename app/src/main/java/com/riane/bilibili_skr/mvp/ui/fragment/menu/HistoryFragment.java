package com.riane.bilibili_skr.mvp.ui.fragment.menu;

import android.app.Activity;
import android.support.v7.widget.Toolbar;

import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.base.SimpleFragment;
import com.riane.basiclib.base.widget.loadsir.EmptyCallback;
import com.riane.basiclib.base.widget.loadsir.EmptyHistoryCallback;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.bilibili_skr.MainActivity;
import com.riane.bilibili_skr.R;

import butterknife.BindView;

/**
 * Created by zhengxiaobo on 2018/11/8.
 */

public class HistoryFragment extends SimpleFragment{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
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
    protected void initData() {
        showPageEmpty();
        mToolbar.setTitle("历史记录");
        mToolbar.setNavigationIcon(R.drawable.ic_navigation_drawer);
        mToolbar.setNavigationOnClickListener(v -> {
            Activity activity1 = getActivity();
            if (activity1 instanceof MainActivity) {
                ((MainActivity) activity1).toggleDrawer();
            }
        });
    }

    @Override
    public void showPageEmpty() {
        if (mLoadService != null) {
            mLoadService.showCallback(EmptyHistoryCallback.class);
        }
    }
}
