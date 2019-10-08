package com.hbwang.api.utils;


import android.text.TextUtils;
import android.util.Log;


/**
 * Created by Administrator on 2018/3/5.
 */

public class HBWangLogUtils {
    /** Log输出的控制开关 */
    public static boolean isShowLog = true;
    public static final String selfFlag = "HBWang";

    public static void i(String msg) {
        if (isShowLog) {
            if (TextUtils.isEmpty(msg)) {
                Log.i(selfFlag, "该log输出信息为空");
            } else {
                Log.i(selfFlag, msg);
            }
        }
    }
    public static void e(String msg) {
        if (isShowLog) {
            if (TextUtils.isEmpty(msg)) {
                Log.e(selfFlag, "该log输出信息为空");
            } else {
                Log.e(selfFlag, msg);
            }
        }
    }
    public static void w(String msg) {
        if (isShowLog) {
            if (TextUtils.isEmpty(msg)) {
                Log.w(selfFlag, "该log输出信息为空");
            } else {
                Log.w(selfFlag, msg);
            }
        }
    }
    public static void d(String msg) {
        if (isShowLog) {
            if (TextUtils.isEmpty(msg)) {
                Log.d(selfFlag, "该log输出信息为空");
            } else {
                Log.d(selfFlag, msg);
            }
        }
    }
    public static void v(String msg) {
        if (isShowLog) {
            if (TextUtils.isEmpty(msg)) {
                Log.v(selfFlag, "该log输出信息为空");
            } else {
                Log.v(selfFlag, msg);
            }
        }
    }
}
