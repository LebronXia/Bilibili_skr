package com.riane.homepage.mvp.presenter;

import com.riane.basiclib.base.CommonSubscriber;
import com.riane.basiclib.base.entity.DataObjectResponse;
import com.riane.basiclib.base.mvp.BasePresenter;
import com.riane.basiclib.di.scope.ActivityScope;
import com.riane.basiclib.utils.RxUtil;
import com.riane.homepage.mvp.contract.IVideoDetailContract;
import com.riane.homepage.mvp.model.entity.VideoDetailInfo;

import javax.inject.Inject;

/**
 * Created by zhengxiaobo on 2018/10/31.
 */
@ActivityScope
public class VideoDetailPresenter extends BasePresenter<IVideoDetailContract.Model, IVideoDetailContract.View>{

    @Inject
    public VideoDetailPresenter(IVideoDetailContract.Model model, IVideoDetailContract.View rootView) {
        super(model, rootView);
    }

    public void getVideoDetail(int id){
        addSubscribe(mModel.getVideoDetail(id)
                .compose(RxUtil.<DataObjectResponse<VideoDetailInfo>>rxSchedulerHelper())
                .map(objectResultObjectResponse ->
                    objectResultObjectResponse.getData()
                )
                .subscribeWith(new CommonSubscriber<VideoDetailInfo>(mView){

                    @Override
                    public void onNext(VideoDetailInfo o) {
                        super.onNext(o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                }
        ));
    }
}
