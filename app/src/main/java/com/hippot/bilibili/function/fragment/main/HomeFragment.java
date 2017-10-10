package com.hippot.bilibili.function.fragment.main;

import com.hippot.bilibili.R;
import com.hippot.bilibili.base.BasicFragment;
import com.hippot.bilibili.base.BasicPresenter;
import com.hippot.bilibili.function.presenter.HomePresenter;

import java.util.Map;

/**
 * Created by teng on 17/9/25.
 */

public class HomeFragment extends BasicFragment<HomePresenter> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void setEvent() {

    }

    @Override
    protected void initData() {
        mPresenter.requestDate(getRequestParams(), BasicPresenter.RequestMode.FRIST);
    }


    private Map<String, String> getRequestParams(){
        return null;
    }

    @Override
    public void showRefreshFinish(Object score) {
        super.showRefreshFinish(score);

    }

    @Override
    protected HomePresenter getChildPresenter() {
        return new HomePresenter(this);
    }
}
