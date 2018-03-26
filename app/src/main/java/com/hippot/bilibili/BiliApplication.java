package com.hippot.bilibili;

import android.app.Application;

import com.hippot.bilibili.module.AppModule;
import com.hippot.bilibili.base.HttpModule;
import com.hippot.bilibili.component.AppComponent;
import com.hippot.bilibili.component.DaggerAppComponent;

/**
 * Created by teng on 17/9/21.
 */

public class BiliApplication extends Application {

    private static AppComponent mComponent;
    public static BiliApplication app;

    public static synchronized BiliApplication getInstance(){
        return app;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static AppComponent getComponent(){

        if (mComponent == null) {
            mComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .httpModule(new HttpModule())
                    .build();
        }
        return mComponent;
    }


}
