package com.hippot.bilibili.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by teng on 17/11/28.
 */

public abstract class SimpleFragment extends Fragment {

    protected View rootView;
    protected Context mContext;
    protected Activity mActivity;
    Unbinder binder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mActivity = (Activity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId() , container , false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binder = ButterKnife.bind(this , rootView);
        initEventAndData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }

    protected abstract int getLayoutId();

    protected abstract void initEventAndData();

}
