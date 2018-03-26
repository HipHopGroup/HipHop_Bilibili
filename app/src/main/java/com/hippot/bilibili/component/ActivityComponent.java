package com.hippot.bilibili.component;

import android.app.Activity;

import com.hippot.bilibili.module.ActivityModule;
import com.hippot.bilibili.function.activity.MainActivity;
import com.hippot.bilibili.scope.ActivityScope;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(MainActivity mainActivity);
}
