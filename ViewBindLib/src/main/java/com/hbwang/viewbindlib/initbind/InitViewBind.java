package com.hbwang.viewbindlib.initbind;

import android.app.Activity;

import com.hbwang.viewbindlib.config.BindViewType;
import com.hbwang.viewbindlib.inject.provider.impl.BindClickFactory;
import com.hbwang.viewbindlib.inject.provider.impl.BindUIFactory;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/25-17:21
 */
public class InitViewBind {
    private static InitViewBind mInitViewBind;

    private InitViewBind() {
    }


    public static InitViewBind getInstance(){
        if (mInitViewBind == null) {
            mInitViewBind = new InitViewBind();
        }
        return mInitViewBind;
    }

    public void init(Activity activity , int ConfigType) {
        switch (ConfigType) {
            case BindViewType.ALL :
                BindUIFactory mBindUIFactory = new BindUIFactory();
                BindClickFactory mBindClickFactory = new BindClickFactory();
                mBindUIFactory.getLayoutProduct(activity).inJectView();
                mBindUIFactory.getViewProduct(activity).inJectView();
                mBindClickFactory.getProduct(activity).inJectClick();
                break;
            case BindViewType.VIEW :
                new BindUIFactory().getViewProduct(activity).inJectView();
                break;
            case BindViewType.LAYOUT :
                new BindUIFactory().getLayoutProduct(activity).inJectView();
                break;
            case BindViewType.CLICK :
                new BindClickFactory().getProduct(activity).inJectClick();
                break;
        }
    }

}
