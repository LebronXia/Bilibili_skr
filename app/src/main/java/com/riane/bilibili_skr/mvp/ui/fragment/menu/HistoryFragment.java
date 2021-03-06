package com.riane.bilibili_skr.mvp.ui.fragment.menu;

import android.app.Activity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

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
   //@BindView(R.id.layout_content)
    RelativeLayout layoutContent;

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
    protected boolean keepTitle() {
        return true;
    }

    @Override
    protected void initData() {
        showPageEmpty();
        //((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        mToolbar.setTitle("历史记录");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        //使左上角图标是否显示
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
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
            mLoadService.showCallback(EmptyHistoryCallback.class);
        }
    }
}
