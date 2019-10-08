package com.hbwang.viewbindlib.inject.provider;

import android.app.Activity;

import com.hbwang.viewbindlib.inject.sender.bindclick.IBindClick;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/25-13:46
 */
public interface IBindClickFactory {
     IBindClick getProduct(Activity activity);
}
