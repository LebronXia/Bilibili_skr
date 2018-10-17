package com.riane.homepage.mvp.model;

import com.riane.basiclib.base.mvp.BaseModel;
import com.riane.basiclib.di.scope.FragmentScope;
import com.riane.basiclib.integration.IRepositoryManager;
import com.riane.homepage.api.ApiHelper;
import com.riane.homepage.api.HomepageService;
import com.riane.homepage.mvp.contract.IHomeRecommendContract;
import com.riane.basiclib.base.entity.DataListResponse;
import com.riane.homepage.mvp.model.entity.RecommentIndexBean;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by zhengxiaobo on 2018/9/30.
 */
@FragmentScope
public class HomeRecommendModel extends BaseModel implements IHomeRecommendContract.Model {

    private String openEvent;
    private int loginEvent;
    private boolean pull;
    public static final int STATE_NORMAL = 0;
    //首次获取数据
    public static final int STATE_INITIAL = 1;
    public static final int STATE_REFRESHING = 2;
    public static final int STATE_LOAD_MORE = 3;

    private static final String OPEN_EVENT_NULL = "";
    private static final String OPEN_EVENT_COLD = "cold";

    private static final int LOGIN_EVENT_NORMAL = 0;
    private static final int LOGIN_EVENT_INITIAL = 1;

    @Inject
    public HomeRecommendModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    /**
     * 根据请求状态更换参数
     */
    private void getIndex(final int oprationState){
        switch (oprationState){
            case STATE_INITIAL:
                openEvent = OPEN_EVENT_COLD;
                loginEvent = LOGIN_EVENT_INITIAL;
                pull = true;
                break;
            case STATE_REFRESHING:
                openEvent = OPEN_EVENT_NULL;
                loginEvent = LOGIN_EVENT_NORMAL;
                pull = true;
                break;
            case STATE_LOAD_MORE:
                openEvent = OPEN_EVENT_NULL;
                loginEvent = LOGIN_EVENT_NORMAL;
                pull = false;
                break;
        }

    }

    @Override
    public Flowable<DataListResponse<RecommentIndexBean>> getRecommendList(int idx, int operationState) {
        getIndex(operationState);
        return mRepositoryManager.obtainRetrofitService(HomepageService.class)
                .getIndex(ApiHelper.ACCESS_KRY,
                        ApiHelper.ACTIONKEY,
                        ApiHelper.AD_EXTRA,
                        ApiHelper.APP_KEY,
                        ApiHelper.BANNER_HASH,
                        ApiHelper.BUILD,
                        ApiHelper.DEVICE,
                        idx,
                        loginEvent,
                        ApiHelper.MOBI_APP,
                        ApiHelper.NET_WORK,
                        openEvent,
                        ApiHelper.PLATFORM,
                        pull,
                        ApiHelper.QN,
                        ApiHelper.STYLE,
                        ApiHelper.TS
                        );
    }
}
