package com.hippot.bilibili.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hippot.bilibili.BiliApplication;
import com.hippot.bilibili.component.DaggerFragmentComponent;
import com.hippot.bilibili.component.FragmentComponent;
import com.hippot.bilibili.module.FragmentModule;
import com.hippot.bilibili.utils.SnackBarUtil;

import javax.inject.Inject;

/**
 * Created by teng on 17/9/22.
 */

public abstract class BasicFragment<T extends BasicPresenter> extends SimpleFragment implements BasicView{

    @Inject
    protected T mPresenter;

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(BiliApplication.getComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackBarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {

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

    protected abstract void initInject();

    protected Activity getSupportActivity(){
        return this.getSupportActivity();
    }
}
