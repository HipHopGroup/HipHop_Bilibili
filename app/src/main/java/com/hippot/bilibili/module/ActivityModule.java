package com.hippot.bilibili.module;

import android.app.Activity;

import com.hippot.bilibili.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by teng on 17/11/27.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
