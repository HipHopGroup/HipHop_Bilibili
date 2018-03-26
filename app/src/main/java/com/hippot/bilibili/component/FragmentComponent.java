package com.hippot.bilibili.component;

import android.app.Activity;

import com.hippot.bilibili.module.FragmentModule;
import com.hippot.bilibili.function.fragment.main.HomeFragment;
import com.hippot.bilibili.scope.FragmentScope;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(HomeFragment homeFragment);

}
