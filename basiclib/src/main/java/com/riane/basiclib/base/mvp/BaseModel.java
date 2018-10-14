package com.riane.basiclib.base.mvp;

import com.riane.basiclib.integration.IRepositoryManager;

/**
 * Created by zhengxiaobo on 2018/8/19.
 */

public class BaseModel implements IModel{

    //用于管理网络请求层,以及数据缓存层
    protected IRepositoryManager mRepositoryManager;

    public BaseModel(IRepositoryManager repositoryManager) {
        this.mRepositoryManager = repositoryManager;
    }

    @Override
    public void onDestroy() {
        mRepositoryManager = null;
    }
}
