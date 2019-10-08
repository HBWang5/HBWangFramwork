package com.hbwang.viewbindlib.inject.sender;

import android.app.Activity;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/25-13:54
 */
public abstract class IBindBase {

    private Activity activity;

    public Activity getContext() {
        return activity;
    }

    public void bindContext(Activity activity) {
        this.activity = activity;
        return;
    }

    public IBindBase() {
        initProduct();
    }

    public abstract void initProduct();
}
