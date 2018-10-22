package com.riane.homepage.mvp.ui.adapter;

import android.animation.ObjectAnimator;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.riane.basiclib.utils.DimenUtils;
import com.riane.basiclib.utils.ImageUtil;
import com.riane.basiclib.utils.StringUtil;
import com.riane.homepage.R;
import com.riane.homepage.mvp.model.entity.BangumiRecommendFallBean;
import com.riane.homepage.mvp.model.entity.HomeBangumiBean;
import com.riane.homepage.mvp.model.entity.Item;
import com.riane.homepage.mvp.model.entity.Items;
import com.riane.homepage.mvp.model.entity.RecommentIndexBean;

import java.util.List;

import static android.animation.ValueAnimator.INFINITE;

/**
 * Created by zhengxiaobo on 2018/10/18.
 */

public class BangumiAdapter extends BaseMultiItemQuickAdapter<Item, BaseViewHolder>{

    public BangumiAdapter(List<Item> data) {
        super(data);
        addItemType(Item.BANGUMI_TOPHOME, R.layout.homepage_item_bangumi_tophome);
        addItemType(Item.BANGUMI_RECOMMENDHEAD, R.layout.homepage_item_bangumi_recommendhead);
        addItemType(Item.BANGUMI_RECOMMENDDETAIL, R.layout.homepage_item_bangumi_recommenddetail);
        addItemType(Item.BANGUMI_RECOMMENDFOOT, R.layout.homepage_item_bangumi_recommendfoot);
        addItemType(Item.BANGUMI_INDEX_FALL, R.layout.homepage_item_bangumi_editorrecommend);
    }

    @Override
    protected void convert(BaseViewHolder helper, Item item) {
        switch (helper.getItemViewType()){
            case Item.BANGUMI_TOPHOME:
                break;
            case Item.BANGUMI_RECOMMENDHEAD:
                helper.setText(R.id.tv_title, (String)item.getData());
                break;
            case Item.BANGUMI_RECOMMENDDETAIL:
                HomeBangumiBean.RecommendBean recommendBean = (HomeBangumiBean.RecommendBean) item.getData();
                if (recommendBean != null){
                    int width = DimenUtils.getScreenWidth(mContext) / 3 - DimenUtils.dpToPx(mContext, 14);
                    int height = width * 4/3;

                    CardView.LayoutParams params = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, height);
                    helper.getView(R.id.rl_cover).setLayoutParams(params);
                    ImageUtil.loadWidthAndHeight(mContext, recommendBean.getCover(), (ImageView) helper.getView(R.id.iv_cover), width, height);
                    if (!TextUtils.isEmpty(recommendBean.getFavourites())){
                        String favourites = String.format(mContext.getResources().getString(R.string.homepage_bangumi_index_text_suffix_hit), StringUtil.numberToWord(Integer.parseInt(recommendBean.getFavourites())));
                        helper.setText(R.id.tv_favourite, favourites);
                    }
                    helper.setText(R.id.tv_title, recommendBean.getTitle());
                    helper.setText(R.id.tv_update, String.format(mContext.getResources().getString(R.string.homepage_bangumi_index_status_format_3), recommendBean.getNewest_ep_index()));
                }
                break;
            case Item.BANGUMI_RECOMMENDFOOT:
                    helper.itemView.setTag(new Item());
                final ImageView mIvRefresh = helper.getView(R.id.iv_refresh);
                    final ObjectAnimator animator = ObjectAnimator.ofFloat(mIvRefresh, "rotation", 0f, 360f);
                    animator.setDuration(600);
                    animator.setRepeatCount(INFINITE);
                    animator.setInterpolator(new LinearInterpolator());
                    helper.getView(R.id.ll_refresh).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (animator.isRunning()){
                                animator.end();
                            } else {
                                animator.start();
                            }
                        }
                    });
                break;
            case Item.BANGUMI_INDEX_FALL:
                BangumiRecommendFallBean recommendFallBean = (BangumiRecommendFallBean) item.getData();
                if (recommendFallBean != null){
                    ImageUtil.load(mContext, recommendFallBean.getCover(), (ImageView) helper.getView(R.id.iv_cover));
                    helper.setText(R.id.tv_title, recommendFallBean.getTitle());
                    if (TextUtils.isEmpty(recommendFallBean.getDesc())){
                        helper.getView(R.id.tv_des).setVisibility(View.GONE);
                    } else {
                        helper.getView(R.id.tv_des).setVisibility(View.VISIBLE);
                        helper.setText(R.id.tv_des, recommendFallBean.getDesc());
                    }
                }
                break;
        }
    }
}
