package com.hippot.bilibili;

import android.os.Bundle;

import com.hippot.bilibili.base.BasicActivity;
import com.hippot.bilibili.utils.BottomNavigationViewHelper;

public class MainActivity extends BasicActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        BottomNavigationViewHelper.disableShiftMode(findViewById(R.id.bottom_navigation));
    }

    @Override
    protected void setEvent() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


}
