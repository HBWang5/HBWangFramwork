package com.hbwang.viewbindlib.inject.sender.bindview.impl;


import android.app.Activity;

import com.hbwang.viewbindlib.inject.sender.IBindBase;
import com.hbwang.viewbindlib.inject.sender.bindview.IBindUI;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/25-13:48
 */
public class BindView extends IBindBase implements IBindUI {

    @Override
    public void initProduct() {

    }

    @Override
    public void inJectView() {
        Class<? extends Activity> clazz = getContext().getClass();
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            com.hbwang.viewbindlib.annotation.BindView annotation = field.getAnnotation(com.hbwang.viewbindlib.annotation.BindView.class);
            if (annotation != null) {
                int viewId = annotation.value();
                try {
                    Method findViewById = clazz.getMethod("findViewById", int.class);
                    Object view = findViewById.invoke(getContext(), viewId);
                    field.setAccessible(true);
                    field.set(getContext(), view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
