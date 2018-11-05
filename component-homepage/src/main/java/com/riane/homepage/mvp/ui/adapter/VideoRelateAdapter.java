package com.riane.homepage.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.riane.basiclib.utils.ImageUtil;
import com.riane.basiclib.utils.StringUtil;
import com.riane.homepage.R;
import com.riane.homepage.mvp.model.entity.VideoDetailInfo;
import com.riane.homepage.mvp.ui.fragment.VideoIntroductionFragment;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/11/4.
 */

public class VideoRelateAdapter extends BaseQuickAdapter<VideoDetailInfo.RelateBean, BaseViewHolder>{

    public VideoRelateAdapter() {
        super(R.layout.homepage_item_vieodetail_relate);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoDetailInfo.RelateBean item) {

        helper.setText(R.id.item_title, item.getTitle());
        helper.setText(R.id.item_user_name, item.getOwner().getName());
        helper.setText(R.id.item_play, StringUtil.numberToWord(item.getStat().getView()));
        helper.setText(R.id.item_review, StringUtil.numberToWord(item.getStat().getDanmaku()));
        ImageUtil.load(mContext, item.getPic(), (ImageView) helper.getView(R.id.item_img));


    }
}
