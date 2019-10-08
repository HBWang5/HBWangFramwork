package com.hbwang.viewbindlib.inject.sender.bindclick.impl;



import android.app.Activity;
import android.view.View;

import com.hbwang.viewbindlib.annotation.click.ClickBase;
import com.hbwang.viewbindlib.inject.sender.IBindBase;
import com.hbwang.viewbindlib.inject.sender.bindclick.IBindClick;
import com.hbwang.viewbindlib.proxy.BindListenerInvocationHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/25-13:48
 */
public class BindClick extends IBindBase implements IBindClick {

    @Override
    public void initProduct() {

    }


    @Override
    public void inJectClick() {
        //获取class
        Class<? extends Activity> clazz = getContext().getClass();
        //获取所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        //便利
        for (Method method : declaredMethods) {
            //得到方法所有注解
            Annotation[] annotations = method.getAnnotations();
            //便利注解
            for (Annotation annotation : annotations) {
                //获取注解类型
                Class<? extends Annotation> annotationType = annotation.annotationType();
                if (annotationType != null) {
                    //获取点击元注解
                    ClickBase clickBase = annotationType.getAnnotation(ClickBase.class);
                    //得到点击事件回调
                    String listenerCallBack = clickBase.listenerCallBack();
                    //得到点击事件方法
                    String listenerSetter = clickBase.listenerSetter();
                    //得到点击事件class
                    Class<?> listenerType = clickBase.listenerType();
                    try {
                        //获取id
                        Method valueMethod = annotationType.getDeclaredMethod("value");
                        int[] valueIds = (int[]) valueMethod.invoke(annotation);
                        BindListenerInvocationHandler bindListenerInvocationHandler = new BindListenerInvocationHandler(getContext());
                        //拦截并执行方法
                        bindListenerInvocationHandler.addMethod(listenerCallBack, method);
                        Object listener = Proxy.newProxyInstance(listenerType.getClassLoader(), new Class[]{listenerType}, bindListenerInvocationHandler);
                        //遍历所有id（执行方法）
                        for (int id : valueIds) {
                            Method findViewById = clazz.getMethod("findViewById", int.class);
                            View view = (View) findViewById.invoke(getContext(), id);
                            Method setter = view.getClass().getMethod(listenerSetter, listenerType);
                            setter.invoke(view, listener);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
