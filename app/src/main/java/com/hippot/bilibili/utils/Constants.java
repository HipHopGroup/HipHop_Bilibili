package com.hippot.bilibili.utils;

import android.os.Environment;

import com.hippot.bilibili.BiliApplication;

import java.io.File;

/**
 * Created by teng on 17/11/27.
 */

public class Constants {

    //================= PATH ====================

    public static final String PATH_DATA = BiliApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";


}
