package com.sharptech.smart.smartbaselibrary.common.component;

import android.os.Environment;

import java.io.File;

/**
 * @author: sunzhibin
 * @date: 2018/2/6.
 * @description:
 * @e-mail:
 */

public class Constants {
    public static final String PATH_SDCARD = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()
            + File.separator;
    //    public static final String PATH_DATA = MainApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_DATA = "" + File.separator + "data";

}
