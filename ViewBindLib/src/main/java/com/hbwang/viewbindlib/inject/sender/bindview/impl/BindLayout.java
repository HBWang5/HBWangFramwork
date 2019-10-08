package com.hbwang.viewbindlib.inject.sender.bindview.impl;


import android.app.Activity;

import com.hbwang.viewbindlib.annotation.ContenView;
import com.hbwang.viewbindlib.inject.sender.IBindBase;
import com.hbwang.viewbindlib.inject.sender.bindview.IBindUI;

import java.lang.reflect.Method;


/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/25-13:48
 */
public class BindLayout extends IBindBase implements IBindUI {

    @Override
    public void initProduct() {

    }

    @Override
    public void inJectView() {
        //获取类
        Class<? extends Activity> clazz = getContext().getClass();
        //获取注解
        ContenView contenView = clazz.getAnnotation(ContenView.class);
        //获取注解值
        if (contenView != null) {
            //获取布局ID
            int layoutId = contenView.value();
            try {
                //执行方法
                Method setContentView = clazz.getMethod("setContentView", int.class);
                setContentView.invoke(getContext(), layoutId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
