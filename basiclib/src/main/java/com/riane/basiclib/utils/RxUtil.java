package com.riane.basiclib.utils;

import com.riane.basiclib.base.entity.ResultListResponse;
import com.riane.basiclib.base.entity.ResultObjectResponse;
import com.riane.basiclib.http.ApiException;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.functions.Function;


public class RxUtil {

  /**
   * Flowable线程切换简化
   */
  public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
    return new FlowableTransformer<T, T>() {
      @Override
      public Flowable<T> apply(Flowable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
      }
    };
  }

  /**
   * Completable线程切换简化
   */
  public static CompletableTransformer completableSchedulerHelper() {
    return new CompletableTransformer() {
      @Override
      public Completable apply(Completable observable) {
        return observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
      }
    };
  }

  /**
   * 统一返回结果处理(结果是result)
   * @param <T>
   * @return
   */
    public static <T> FlowableTransformer<ResultObjectResponse<T>, T> handleResultObjectResult() {   //compose判断结果
        return new FlowableTransformer<ResultObjectResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<ResultObjectResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<ResultObjectResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(ResultObjectResponse<T> tGoldHttpResponse) {
                        if(tGoldHttpResponse.getResult() != null) {
                            return createData(tGoldHttpResponse.getResult());
                        } else {
                            return Flowable.error(new ApiException(tGoldHttpResponse.getMessage()));
                        }
                    }
                });
            }
        };
    }

  /**
   * 生成Flowable
   */
  public static <T> Flowable<T> createData(final T t) {
    return Flowable.create(new FlowableOnSubscribe<T>() {
      @Override
      public void subscribe(FlowableEmitter<T> emitter) throws Exception {
        try {
          emitter.onNext(t);
          emitter.onComplete();
        } catch (Exception e) {
          emitter.onError(e);
        }
      }
    }, BackpressureStrategy.BUFFER);
  }
}
