package com.riane.channel.mvp.contract;

import com.riane.basiclib.base.entity.DataListResponse;
import com.riane.basiclib.base.mvp.IModel;
import com.riane.basiclib.base.mvp.IView;
import com.riane.channel.mvp.model.entity.ChannelBean;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by zhengxiaobo on 2018/10/22.
 */

public interface IChannelMainContract {
    interface View extends IView {
        void showChannelClassfifies(List<ChannelBean> channelBeans);
    }

    interface Model extends IModel {
        Flowable<DataListResponse<ChannelBean>> getChannelList();
    }
}
