package com.hbwang.viewbindlib.annotation.click;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/22-15:34
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClickBase {

    String listenerSetter();

    Class<?> listenerType();

    String listenerCallBack();
}
