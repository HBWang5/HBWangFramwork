package com.hbwang.api.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2018/1/23.
 */

public class WindowMetricTools {

    private static WindowMetricTools mWindowMetricTools;
    private static DisplayMetrics metric;


    private WindowMetricTools() {
    }

    public synchronized static WindowMetricTools getInstance() {
        if (mWindowMetricTools == null) {
            mWindowMetricTools = new WindowMetricTools();

        }
        return mWindowMetricTools;
    }
    public void init(Activity activity){
        metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
    }
    public int getWidth(){
        return  metric.widthPixels;  // 屏幕宽度（像素）
    }
    public int getHeight(){
        return  metric.heightPixels;  // 屏幕高度（像素）
    }
    public float getDensity(){
        return  metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
    }
    public int  getDensityDpi(){
        return  metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
    }


}
