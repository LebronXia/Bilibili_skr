package com.riane.channel;

import android.widget.FrameLayout;

import com.riane.basiclib.base.SimpleActivity;
import com.riane.channel.mvp.ui.fragment.ChannelFragment;
import com.riane.channel.R;

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
        ChannelFragment channelFragment = new ChannelFragment();
        loadRootFragment(R.id.layout_load_fragment, channelFragment);
    }
}
