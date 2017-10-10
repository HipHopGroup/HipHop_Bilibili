package com.hippot.bilibili.base;

public interface BasicView {

    void showLoading();

    void refreshView();

    void showNetError();

    void showEmptyView(String msg);

//    void hasNoMoreDate();

//    void loadMoreFinish(Object dates);

    void showRefreshFinish(Object score);

    void showToastError();
}
