package com.hbwang.viewbindlib.inject.provider;

import android.app.Activity;

import com.hbwang.viewbindlib.inject.sender.bindview.IBindUI;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/25-13:46
 */
public interface IBindUIFactory {

    IBindUI getViewProduct(Activity activity);

    IBindUI getLayoutProduct(Activity activity);
}
