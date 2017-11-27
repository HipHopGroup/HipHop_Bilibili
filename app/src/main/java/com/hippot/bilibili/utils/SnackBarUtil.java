package com.hippot.bilibili.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by teng on 17/11/27.
 */

public class SnackBarUtil {

    public static void show(View view, String msg){
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showShort(View view, String msg){
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }

}
