package com.sharptech.smart.core.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jingbin on 2016/12/14.
 * 单例Toast
 */

public class ToastUtil {
    private static Toast mToast;

    public static void shortShow(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
        }
        mToast.setText(text);
        mToast.show();
    }

    public static void hideToast() {
        mToast.cancel();
        mToast = null;
    }
}
