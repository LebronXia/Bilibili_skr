package com.riane.channel.mvp.model.entity;

import com.riane.basiclib.base.entity.DataListResponse;
import com.riane.basiclib.base.mvp.BaseModel;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.basiclib.http.api.ApiHelper;
import com.riane.basiclib.integration.IRepositoryManager;
import com.riane.basiclib.utils.DateUtil;
import com.riane.channel.api.ChannelService;
import com.riane.channel.mvp.contract.IChannelMainContract;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by zhengxiaobo on 2018/10/22.
 */
@FragmentScope
public class ChannelMainModel extends BaseModel implements IChannelMainContract.Model{

    @Inject
    public ChannelMainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Flowable<DataListResponse<ChannelBean>> getChannelList() {
        return mRepositoryManager.obtainRetrofitService(ChannelService.class)
                .getChannels(ApiHelper.BUILD);
    }
}
