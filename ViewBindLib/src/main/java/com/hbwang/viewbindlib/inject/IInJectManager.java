package com.hbwang.viewbindlib.inject;

import android.app.Activity;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/22-15:15
 */
public interface IInJectManager {
    /**
     * 布局注入
     */
    void inJectLayout(Activity activity);

    /**
     * View注入
     */
    void inJectView(Activity activity);

    /**
     * Click注入
     */
    void inJectClick(Activity activity);
}
