package com.hippot.bilibili.presenter;

import com.hippot.bilibili.Contract.HomeContract;
import com.hippot.bilibili.base.RxPresenter;

import io.reactivex.disposables.Disposable;

/**
 * Created by teng on 18/3/26.
 */

public class HomePresenter extends RxPresenter<HomeContract.View> implements HomeContract.Presenter  {

    private Disposable subscription;


    @Override
    public void getData() {

    }



}
