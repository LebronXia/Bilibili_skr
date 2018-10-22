package com.riane.channel.mvp.presenter;

import com.riane.basiclib.base.CommonSubscriber;
import com.riane.basiclib.base.entity.DataListResponse;
import com.riane.basiclib.base.mvp.BasePresenter;
import com.riane.basiclib.utils.RxUtil;
import com.riane.channel.mvp.contract.IChannelMainContract;
import com.riane.channel.mvp.model.entity.ChannelBean;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

/**
 * Created by zhengxiaobo on 2018/10/22.
 */

public class ChannelMainPresenter extends BasePresenter<IChannelMainContract.Model, IChannelMainContract.View>{

    @Inject
    public ChannelMainPresenter(IChannelMainContract.Model model, IChannelMainContract.View rootView) {
        super(model, rootView);
    }

    public void getChannels(){
        addSubscribe(mModel.getChannelList()
                .compose(RxUtil.<DataListResponse<ChannelBean>>rxSchedulerHelper())
                .map(new Function<DataListResponse<ChannelBean>, List<ChannelBean>>() {
                    @Override
                    public List<ChannelBean> apply(DataListResponse<ChannelBean> channelBeanDataListResponse) throws Exception {
                        return channelBeanDataListResponse.getData();
                    }
                })
                .subscribeWith(new CommonSubscriber<List<ChannelBean>>(mView){
                    @Override
                    public void onNext(List<ChannelBean> o) {
                        super.onNext(o);
                        mView.showChannelClassfifies(o);
                        mView.showPageContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.showPageError();
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        mView.hideLoading();
                    }
                }));
    }
}
