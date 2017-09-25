package com.hippot.bilibili.function.presenter;

import com.hippot.bilibili.base.BasicPresenter;
import com.hippot.bilibili.base.BasicView;

import java.util.Map;

import rx.Observable;

/**
 * Created by teng on 17/9/25.
 */

public class HomePresenter extends BasicPresenter {

    private BasicView mainView;

    public HomePresenter(BasicView mainView){
        this.mainView = mainView;
    }


    @Override
    protected void onSuccess(Object o) {
        super.onSuccess(o);
//        HttpResult<>
        if (mode == RequestMode.FRIST || mode == RequestMode.REFRESH){
            mainView.showRefreshFinish(o);
        }else if (mode == RequestMode.LOAD_MORE){
            mainView.showRefreshFinish(o);
        }
    }

    @Override
    protected void onFail() {

    }

    @Override
    protected void onFinish() {
        super.onFinish();

    }

    @Override
    protected Observable getObservable(Map<String, String> params) {
        return getService().getRecommendedInfo();
    }
}
