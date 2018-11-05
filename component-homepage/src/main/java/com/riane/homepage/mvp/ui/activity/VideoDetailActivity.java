package com.riane.homepage.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.hss01248.dialog.Tool;
import com.jaeger.library.StatusBarUtil;
import com.riane.basiclib.base.BaseActivity;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.basiclib.utils.DimenUtils;
import com.riane.basiclib.utils.ImageUtil;
import com.riane.basiclib.utils.constant.CommonConstantUtil;
import com.riane.homepage.R;
import com.riane.homepage.R2;
import com.riane.homepage.di.component.DaggerVideoDetailComponent;
import com.riane.homepage.di.module.VideoDetailModule;
import com.riane.homepage.mvp.contract.IVideoDetailContract;
import com.riane.homepage.mvp.model.entity.VideoDetailInfo;
import com.riane.homepage.mvp.presenter.VideoDetailPresenter;
import com.riane.homepage.mvp.ui.fragment.VideoCommentFragment;
import com.riane.homepage.mvp.ui.fragment.VideoIntroductionFragment;
import com.riane.homepage.mvp.ui.support.AppBarStateChangeEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by zhengxiaobo on 2018/11/1.
 */

public class VideoDetailActivity extends BaseActivity<VideoDetailPresenter> implements IVideoDetailContract.View{

    @BindView(R2.id.toolbar)
    Toolbar mToolbar;
    @BindView(R2.id.tv_av_title)
    TextView mTvAvTitle;
    @BindView(R2.id.tv_player)
    TextView mTvPalyer;
    @BindView(R2.id.video_preview)
    ImageView mVideoPreview;
    @BindView(R2.id.tab_layout)
    SlidingTabLayout mTabLayout;
    @BindView(R2.id.view_pager)
    ViewPager mViewPager;
    @BindView(R2.id.app_bar)
    AppBarLayout mAppBarLayout;

    private int av = -1;
    private String imgUrl;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();
    private VideoIntroductionFragment introductionFragment;
    private VideoCommentFragment commentFragment;

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
    protected boolean useLoadSir() {
        return true;
    }

    @Override
    protected void onPageRetry(android.view.View v) {
        mPresenter.getVideoDetail(av);
    }

    @Override
    protected void initData() {
        setToolBar(mToolbar, "");
        Intent intent = getIntent();
        if (intent != null) {
            av = intent.getIntExtra(CommonConstantUtil.EXTRA_AV, -1);
            imgUrl = intent.getStringExtra(CommonConstantUtil.EXTRA_img_url);
        }
        if (av == -1){
            showError(R.string.msg_error_unknown);
            return;
        }
        mTvAvTitle.setVisibility(View.VISIBLE);
        mTvAvTitle.setText("av" + av);
        ImageUtil.load(mContext, imgUrl, mVideoPreview);

        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeEvent() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset) {
                if (state == State.EXPANDED){
                    mTvPalyer.setVisibility(View.GONE);
                    mTvAvTitle.setVisibility(View.VISIBLE);
                    mToolbar.setContentInsetsRelative(DimenUtils.dpToPx(VideoDetailActivity.this, 15), 0);
                } else if (state == State.COLLAPSED){
                    mTvPalyer.setVisibility(View.VISIBLE);
                    mTvAvTitle.setVisibility(View.GONE);
                    mToolbar.setContentInsetsRelative(DimenUtils.dpToPx(VideoDetailActivity.this, 150), 0);
                } else {
                    mTvPalyer.setVisibility(View.GONE);
                    mTvAvTitle.setVisibility(View.VISIBLE);
                    mToolbar.setContentInsetsRelative(DimenUtils.dpToPx(VideoDetailActivity.this, 15), 0);
                }
            }
        });

        introductionFragment = VideoIntroductionFragment.newInstance(av);
        commentFragment = VideoCommentFragment.newInstance(av);
        mFragments.add(introductionFragment);
        mFragments.add(commentFragment);
        mPresenter.getVideoDetail(av);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageView(this, 0, mToolbar);
    }

    private void setPagerTitle(int num) {
        titles.add("简介");
        titles.add("评论" + num );
        VideoDetailPagerAdapter mAdapter = new VideoDetailPagerAdapter(getSupportFragmentManager(), mFragments, titles);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mTabLayout.setViewPager(mViewPager);
        measureTabLayoutTextWidth(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                measureTabLayoutTextWidth(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void measureTabLayoutTextWidth(int position) {
        String title = titles.get(position);
        TextView textView = mTabLayout.getTitleView(position);
        TextPaint paint = textView.getPaint();
        float textWidth = paint.measureText(title);
        mTabLayout.setIndicatorWidth(textWidth / 3);
    }

    @Override
    public void showVideoDetail(VideoDetailInfo videoDetail) {
        setPagerTitle(videoDetail.getStat().getReply());

    }


    public static void startActivity(Activity activity, int aid, String imgUrl){
        Intent intent = new Intent(activity, VideoDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(CommonConstantUtil.EXTRA_AV, aid);
        intent.putExtra(CommonConstantUtil.EXTRA_img_url, imgUrl);
        activity.startActivity(intent);
    }

    public static class VideoDetailPagerAdapter extends FragmentStatePagerAdapter{
        private List<Fragment> fragments;
        private List<String> titles;
        public VideoDetailPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
            super(fm);
            this.fragments = fragments;
            this.titles = titles;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
    }
}
