package com.riane.channel.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.riane.basiclib.utils.ImageUtil;
import com.riane.channel.R;
import com.riane.channel.mvp.model.entity.ChannelBean;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/10/22.
 */

public class ChannelClassfifyAdapter extends BaseQuickAdapter<ChannelBean, BaseViewHolder>{


    public ChannelClassfifyAdapter() {
        super(R.layout.channel_item_channel, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChannelBean item) {
        helper.setText(R.id.tv_des, item.getName());
        ImageUtil.load(mContext, item.getLogo(), (ImageView) helper.getView(R.id.iv_classfify));
    }
}
