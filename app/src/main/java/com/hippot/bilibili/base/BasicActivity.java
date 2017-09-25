package com.hippot.bilibili.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.trello.rxlifecycle.components.support.RxFragmentActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by teng on 17/9/21.
 */

public abstract class BasicActivity extends RxFragmentActivity {
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(getActivity());
        initViews();
        initData(savedInstanceState);
        setEvent();
    }

    /**
     * 设置布局
     * @return
     */
    protected abstract int getLayoutId();

    protected abstract void initViews();

    protected abstract void setEvent();

    protected abstract void initData(Bundle savedInstanceState);


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    protected Activity getActivity(){
        return this;
    }

    protected Context getContext(){
        return this;
    }
}
