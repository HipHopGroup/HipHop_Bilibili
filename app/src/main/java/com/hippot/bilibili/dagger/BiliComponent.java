package com.hippot.bilibili.dagger;

import com.hippot.bilibili.base.BasicPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by teng on 17/9/25.
 */
@Singleton
@Component(modules = BiliModules.class)
public interface BiliComponent {

    void inject(BasicPresenter presenter);

    final class BiliComponentInitialize{

        public static BiliComponent init(){
            return DaggerBiliComponent.builder().build();
        }

    }
}
