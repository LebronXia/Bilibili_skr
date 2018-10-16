package com.riane.homepage.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.riane.basiclib.imageloader.glide.GlideImageConfig;
import com.riane.basiclib.utils.Utils;
import com.riane.homepage.R;
import com.riane.homepage.mvp.model.entity.HomepageBannerBean;
import com.riane.homepage.mvp.model.entity.RecommentIndexBean;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/10/15.
 */

public class RecommentAdapter extends BaseMultiItemQuickAdapter<RecommentIndexBean, BaseViewHolder>{

    public RecommentAdapter(List data) {
        super(data);
        addItemType(RecommentIndexBean.BANNER, R.layout.homepage_item_banner);
        addItemType(RecommentIndexBean.INDEX, R.layout.homepage_item_recomment);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommentIndexBean item) {

        switch (helper.getItemViewType()){
            case RecommentIndexBean.BANNER:
                MZBannerView bannerview = helper.getView(R.id.bannerview);
                bannerview.setPages(item.getBanner_item(), new MZHolderCreator() {
                    @Override
                    public MZViewHolder createViewHolder() {
                        return new BannerViewHolder();
                    }
                });
                bannerview.start();
                break;
            case RecommentIndexBean.INDEX:
                //helper.setText(R.id.tv_play_amount, item.getPlay());
                //helper.setText(R.id.tv_reply_amount, item.getReply());
                helper.setText(R.id.tv_title, item.getTitle());
                helper.setText(R.id.tv_name, item.getTag() == null ? "" : item.getTag().getTag_name());
                Utils.getAppComponent().imageLoder()
                        .loadImage(mContext,
                                GlideImageConfig
                                        .builder()
                                        .url(item.getCover())
                                        .imagerView((ImageView) helper.getView(R.id.imageview))
                                        .build());
                break;
        }
    }

    public static class BannerViewHolder implements MZViewHolder<HomepageBannerBean> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.homepage_layout_banner,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, HomepageBannerBean data) {
            Utils.getAppComponent().imageLoder()
                    .loadImage(context,
                            GlideImageConfig
                                    .builder()
                                    .url(data.getImage())
                                    .imagerView(mImageView)
                                    .build());
        }
    }
}
