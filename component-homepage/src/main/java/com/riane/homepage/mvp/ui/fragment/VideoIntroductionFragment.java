package com.riane.homepage.mvp.ui.fragment;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.riane.basiclib.base.BaseFragment;
import com.riane.basiclib.di.component.AppComponent;
import com.riane.basiclib.utils.ImageUtil;
import com.riane.basiclib.utils.StringUtil;
import com.riane.basiclib.utils.constant.CommonConstantUtil;
import com.riane.homepage.R;
import com.riane.homepage.R2;
import com.riane.homepage.di.component.DaggerVideoDetailComponent;
import com.riane.homepage.di.module.VideoDetailModule;
import com.riane.homepage.mvp.contract.IVideoDetailContract;
import com.riane.homepage.mvp.model.entity.VideoDetailInfo;
import com.riane.homepage.mvp.presenter.VideoDetailPresenter;
import com.riane.homepage.mvp.ui.activity.VideoDetailActivity;
import com.riane.homepage.mvp.ui.adapter.VideoRelateAdapter;
import com.riane.homepage.mvp.ui.support.RecycleViewDivider;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zhengxiaobo on 2018/11/2.
 */

public class VideoIntroductionFragment extends BaseFragment<VideoDetailPresenter> implements IVideoDetailContract.View{

    @BindView(R2.id.iv_useravator)
    CircleImageView mIvUser;
    @BindView(R2.id.tv_up_name)
    TextView mTvUpName;
    @BindView(R2.id.tv_up_fans)
    TextView mTvUpFans;
    @BindView(R2.id.tv_title)
    TextView mTvTitle;
    @BindView(R2.id.tv_detail_description)
    ExpandableTextView mExpTvDescription;
    @BindView(R2.id.expandable_text)
    TextView mTvDescription;
    @BindView(R2.id.tv_play_time)
    TextView mTvPlayTime;
    @BindView(R2.id.tv_review_count)
    TextView mTvReviewCount;

    @BindView(R2.id.recycle)
    RecyclerView mRecyclerView;

    int av;
    private VideoRelateAdapter mVideoRelateAdapter;

    @Override
    public void setFragmentComponent(AppComponent fragmentComponent) {
        DaggerVideoDetailComponent.builder()
                .appComponent(fragmentComponent)
                .videoDetailModule(new VideoDetailModule(this))
                .build().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.homepage_fragment_videocomment;
    }

    public static VideoIntroductionFragment newInstance(int aid) {
        VideoIntroductionFragment fragment = new VideoIntroductionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(CommonConstantUtil.EXTRA_AV, aid);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initData() {
        av = getArguments().getInt(CommonConstantUtil.EXTRA_AV);
        mVideoRelateAdapter = new VideoRelateAdapter();
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayout.VERTICAL,
                2, getActivity().getResources().getColor(R.color.gray_light)));
        mRecyclerView.setAdapter(mVideoRelateAdapter);
        mPresenter.getVideoDetail(av);

    }

    @Override
    public void showVideoDetail(VideoDetailInfo videoDetail) {
        //设置up主信息
        mTvUpName.setText(videoDetail.getOwner().getName());
        mTvUpFans.setText(StringUtil.numberToWord(videoDetail.getOwner().getMid()));
        ImageUtil.load(mContext, videoDetail.getOwner().getFace(), mIvUser);

        mTvPlayTime.setText(StringUtil.numberToWord(videoDetail.getStat().getView()));
        mTvReviewCount.setText(StringUtil.numberToWord(videoDetail.getStat().getDanmaku()));
        //设置标题,描述
        mTvTitle.setText(videoDetail.getTitle());
        mExpTvDescription.setText(videoDetail.getDesc());

        //设置视频
        mVideoRelateAdapter.setNewData(videoDetail.getRelates());
    }
}
