package com.hippot.bilibili.base;

/**
 * Created by teng on 17/11/27.
 */

public interface BasicPresenter<T extends BasicView> {

    void attachView(T view);

    void detachView();

}
