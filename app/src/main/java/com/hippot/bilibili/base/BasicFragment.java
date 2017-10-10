package com.hippot.bilibili.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by teng on 17/9/22.
 */

public abstract class BasicFragment<T extends BasicPresenter> extends RxFragment implements BasicView{

    protected View rootView;
    protected T mPresenter;
    Unbinder binder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId() , container , false);

        if (null != getChildPresenter()){
            mPresenter = getChildPresenter();
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binder = ButterKnife.bind(this , rootView);

        initViews();
        setEvent();
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }

    protected abstract int getLayoutId();

    protected abstract void initViews();

    protected abstract void setEvent();

    protected abstract void initData();

    protected void showNetWorkError(){

    }

    protected void showEmptyView(){

    }

    protected T getChildPresenter() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void refreshView() {

    }

    @Override
    public void showNetError() {

    }

    @Override
    public void showEmptyView(String msg) {

    }

    @Override
    public void showRefreshFinish(Object score) {

    }

    @Override
    public void showToastError() {

    }

    protected Activity getSupportActivity(){
        return this.getSupportActivity();
    }
}
