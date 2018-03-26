package com.hippot.bilibili.function.fragment.main;

import com.hippot.bilibili.R;
import com.hippot.bilibili.base.RootFragment;

/**
 * Created by teng on 17/9/25.
 */

public class HomeFragment extends RootFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}
