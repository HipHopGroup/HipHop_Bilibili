package com.hippot.bilibili.component;


import com.hippot.bilibili.BiliApplication;
import com.hippot.bilibili.module.AppModule;
import com.hippot.bilibili.base.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    BiliApplication getContext();  // 提供App的Context

//    DataManager getDataManager(); //数据中心
//
//    RetrofitHelper retrofitHelper();  //提供http的帮助类
//
//    RealmHelper realmHelper();    //提供数据库帮助类
//
//    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
}
