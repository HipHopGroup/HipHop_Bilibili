package com.hippot.bilibili;

import android.content.Intent;
import android.os.Bundle;

import com.hippot.bilibili.utils.SystemBarHelper;
import com.trello.rxlifecycle.components.RxActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class SplashActivity extends RxActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SystemBarHelper.hideStatusBar(getWindow());
        setUpSplash();
    }


    private void setUpSplash() {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> finishTask());
    }

    private void finishTask() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
