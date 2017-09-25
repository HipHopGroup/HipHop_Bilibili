package com.hippot.bilibili.base;

import com.hippot.bilibili.BiliApplication;
import com.hippot.bilibili.function.service.BiliAppService;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by teng on 17/9/25.
 */

public abstract class BasicPresenter {

    @Inject
    BiliAppService mService;

    Subscription mSubscription;

    protected RequestMode mode = RequestMode.FRIST;

    public enum RequestMode {
        FRIST, LOAD_MORE, REFRESH
    }

    public BasicPresenter() {
        BiliApplication.getComponent().inject(this);
    }

    @SuppressWarnings("unchecked")
    public void requestDate(Map<String, String> params, RequestMode mode) {
        if (null == getObservable(params)){
            throw new IllegalArgumentException("No Observable");
        }

        this.mode = mode;

        mSubscription = getObservable(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
                    @Override
                    public void onCompleted() {
                        onFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        onFail();
                    }

                    @Override
                    public void onNext(Object o) {
                        if (o != null){
                            onSuccess(o);
                        }else {
                            onFail();
                        }
                    }
                });
    }

    protected void onSuccess(Object o) {

    }

    protected void onFinish() {

    }

    protected void onFail(){

    }

    public BiliAppService getService() {
        return mService;
    }

    protected abstract Observable getObservable(Map<String, String> params);


}
