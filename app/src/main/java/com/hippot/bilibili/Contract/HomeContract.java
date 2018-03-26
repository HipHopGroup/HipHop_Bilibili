package com.hippot.bilibili.Contract;

import com.hippot.bilibili.base.BasicPresenter;
import com.hippot.bilibili.base.BasicView;

/**
 * Created by teng on 18/3/26.
 */

public interface HomeContract {

    interface View extends BasicView{
        void showContent();
    }

    interface Presenter extends BasicPresenter<View> {
        void getData();
    }

}
