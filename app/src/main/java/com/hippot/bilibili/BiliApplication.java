package com.hippot.bilibili;

import android.app.Application;
import android.content.Context;

import com.hippot.bilibili.dagger.BiliComponent;

/**
 * Created by teng on 17/9/21.
 */

public class BiliApplication extends Application {

    private BiliComponent mComponent;
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mComponent = BiliComponent.BiliComponentInitialize.init();
    }

    public static BiliComponent getComponent(){
        return ((BiliApplication)mContext.getApplicationContext()).mComponent;
    }


}
