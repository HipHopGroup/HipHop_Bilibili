package com.hippot.bilibili.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by teng on 17/11/27.
 */

public abstract class SimpleActivity extends FragmentActivity {
    private Unbinder bind;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
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
}
