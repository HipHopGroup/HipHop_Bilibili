package com.hippot.bilibili;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;

import com.hippot.bilibili.base.BasicActivity;
import com.hippot.bilibili.utils.BottomNavigationViewHelper;

import butterknife.BindView;

public class MainActivity extends BasicActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigationView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
    }

    @Override
    protected void setEvent() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


}
