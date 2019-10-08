package com.hbwang.api.handler;

import android.app.Activity;
import android.os.Handler;

import java.lang.ref.WeakReference;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/7-17:32
 */
public abstract class HBWangHandler extends Handler {
    //持有弱引用MainActivity,GC回收时会被回收掉.
    private WeakReference<Activity> mActivity;
    public void bindContext(Activity activity) {
        mActivity = new WeakReference<>(activity);
    }

}
