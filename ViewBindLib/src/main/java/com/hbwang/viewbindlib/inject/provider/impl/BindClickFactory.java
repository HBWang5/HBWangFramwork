package com.hbwang.viewbindlib.inject.provider.impl;

import android.app.Activity;

import com.hbwang.viewbindlib.inject.provider.IBindFactoryBase;
import com.hbwang.viewbindlib.inject.provider.IBindClickFactory;
import com.hbwang.viewbindlib.inject.sender.bindclick.IBindClick;
import com.hbwang.viewbindlib.inject.sender.bindclick.impl.BindClick;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/25-13:47
 */
public class BindClickFactory extends IBindFactoryBase implements IBindClickFactory {

    private BindClick mIBindClick;

    @Override
    public IBindClick getProduct(Activity activity) {
        mIBindClick =  new BindClick();
        mIBindClick.bindContext(activity);
        return  mIBindClick;
    }

}
