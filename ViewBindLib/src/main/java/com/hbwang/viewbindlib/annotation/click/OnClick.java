package com.hbwang.viewbindlib.annotation.click;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/22-15:33
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ClickBase(listenerSetter = "setOnClickListener",listenerType = View.OnClickListener.class,listenerCallBack = "onClick")
public @interface OnClick {
    int[] value();

}
