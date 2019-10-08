package com.hbwang.viewbindlib.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/25-17:14
 */
public interface HBWangInvocationHandler extends InvocationHandler{
    /**
     * 需要拦截的方法
     */
    void addMethod(String methodName, Method method);
}
