package com.hbwang.viewbindlib.inject.provider.impl;

import android.app.Activity;

import com.hbwang.viewbindlib.inject.provider.IBindFactoryBase;
import com.hbwang.viewbindlib.inject.provider.IBindUIFactory;
import com.hbwang.viewbindlib.inject.sender.bindview.IBindUI;
import com.hbwang.viewbindlib.inject.sender.bindview.impl.BindLayout;
import com.hbwang.viewbindlib.inject.sender.bindview.impl.BindView;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/25-13:47
 */
public class BindUIFactory extends IBindFactoryBase implements IBindUIFactory {

    private IBindUI mBindView;


    @Override
    public IBindUI getViewProduct(Activity activity) {
        mBindView = new BindView();
        mBindView.bindContext(activity);
        return mBindView;
    }

    @Override
    public IBindUI getLayoutProduct(Activity activity) {
        mBindView = new BindLayout();
        mBindView.bindContext(activity);
        return mBindView;
    }
}
