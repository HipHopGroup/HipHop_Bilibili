package com.hippot.bilibili.utils;

import android.view.Window;
import android.view.WindowManager;

/**
 * Created by teng on 17/9/21.
 */

public class SystemBarHelper {

    /**
     * 显示隐藏StatusBar
     * @param window
     */
    public static void hideStatusBar(Window window){
        WindowManager.LayoutParams p = window.getAttributes();
        p.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        window.setAttributes(p);
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}
