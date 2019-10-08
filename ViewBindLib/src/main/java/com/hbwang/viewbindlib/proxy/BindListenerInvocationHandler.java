package com.hbwang.viewbindlib.proxy;


import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/22-15:56
 */
public class BindListenerInvocationHandler implements HBWangInvocationHandler{
    private Object mTarget;
    private HashMap<String , Method> hashMap = new HashMap<>();

    public BindListenerInvocationHandler(Object target) {
        this.mTarget = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        if (mTarget != null) {
            method = hashMap.get(method.getName());
            if (method != null) {
                return method.invoke(mTarget,args);
            }
        }
        return null;
    }

    /**
     * 需要拦截的方法
     */
    public void addMethod(String methodName, Method method){
        hashMap.put(methodName,method);
    }
}
