package com.riane.homepage.mvp.ui.fragment;

import android.os.Bundle;

import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.basiclib.utils.constant.CommonConstantUtil;
import com.riane.homepage.R;

/**
 * Created by zhengxiaobo on 2018/11/2.
 */

public class VideoCommentFragment extends BaseFragment{
    @Override
    public void setFragmentComponent(AppComponent fragmentComponent) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.homepage_fragment_video_introduction;
    }

    public static VideoCommentFragment newInstance(int aid) {
        VideoCommentFragment fragment = new VideoCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(CommonConstantUtil.EXTRA_AV, aid);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initData() {

    }
}
