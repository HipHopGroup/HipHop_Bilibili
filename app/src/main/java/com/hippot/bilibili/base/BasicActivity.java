package com.hippot.bilibili.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.hippot.bilibili.BiliApplication;
import com.hippot.bilibili.component.ActivityComponent;
import com.hippot.bilibili.component.DaggerActivityComponent;
import com.hippot.bilibili.module.ActivityModule;
import com.hippot.bilibili.utils.SnackBarUtil;

import javax.inject.Inject;

/**
 * Created by teng on 17/9/21.
 */
public abstract class BasicActivity<T extends BasicPresenter> extends SimpleActivity implements BasicView{


    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();
        if (mPresenter != null){
            mPresenter.attachView(this);
        }
    }

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(BiliApplication.getComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackBarUtil.show(findViewById(android.R.id.content), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {

        recreate();
    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

    protected Activity getActivity(){
        return this;
    }

    protected Context getContext(){
        return this;
    }

    protected abstract void initInject();
}
