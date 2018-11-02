package com.riane.homepage.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hss01248.dialog.Tool;
import com.jaeger.library.StatusBarUtil;
import com.riane.basiclib.base.BaseActivity;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.basiclib.utils.ImageUtil;
import com.riane.basiclib.utils.constant.CommonConstantUtil;
import com.riane.homepage.R;
import com.riane.homepage.R2;
import com.riane.homepage.di.component.DaggerVideoDetailComponent;
import com.riane.homepage.di.module.VideoDetailModule;
import com.riane.homepage.mvp.contract.IVideoDetailContract;
import com.riane.homepage.mvp.presenter.VideoDetailPresenter;

import butterknife.BindView;

/**
 * Created by zhengxiaobo on 2018/11/1.
 */

public class VideoDetailActivity extends BaseActivity<VideoDetailPresenter> implements IVideoDetailContract.View{

    @BindView(R2.id.toolbar)
    Toolbar mToolbar;
    @BindView(R2.id.tv_av_title)
    TextView mTvAvTitle;
    @BindView(R2.id.video_preview)
    ImageView mVideoPreview;

    private int av;
    private String imgUrl;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerVideoDetailComponent.builder()
                .appComponent(appComponent)
                .videoDetailModule(new VideoDetailModule(this))
                .build().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.homepage_activity_videodetail;
    }

    @Override
    protected void initData() {
        setToolBar(mToolbar, "");
        Intent intent = getIntent();
        if (intent != null) {
            av = intent.getIntExtra(CommonConstantUtil.EXTRA_AV, -1);
            imgUrl = intent.getStringExtra(CommonConstantUtil.EXTRA_img_url);
        }
        mTvAvTitle.setVisibility(View.VISIBLE);
        mTvAvTitle.setText("av" + av);
        ImageUtil.load(mContext, imgUrl, mVideoPreview);
        mPresenter.getVideoDetail(av);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageView(this, 0, mToolbar);
    }

    private void setPagerTitle(String num) {

    }

    @Override
    public void showVideoDetail(Object videoDetail) {
        //setPagerTitle(videoDetail.);

    }


    public static void startActivity(Activity activity, int aid, String imgUrl){
        Intent intent = new Intent(activity, VideoDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(CommonConstantUtil.EXTRA_img_url, imgUrl);
        activity.startActivity(intent);
    }
}
