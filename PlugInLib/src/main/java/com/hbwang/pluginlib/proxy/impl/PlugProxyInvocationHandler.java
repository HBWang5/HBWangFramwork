package com.hbwang.pluginlib.proxy.impl;


import android.app.Activity;

import com.hbwang.pluginlib.manager.impl.PlugInManager;
import com.hbwang.pluginlib.pluginapk.PlugInApk;
import com.hbwang.pluginlib.pluglifecycle.IPlugActivity;
import com.hbwang.pluginlib.proxy.IPlugProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/26-10:44
 */
public class PlugProxyInvocationHandler implements InvocationHandler,IPlugProxy{
    private Object subject;
    private PlugInApk mPlugInApk;
    private IPlugActivity mIPlugActivity;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method != null) {
            return method.invoke(mIPlugActivity,args);
        }
        return null;
    }


    @Override
    public void bindPlugInApk(String activityName) {
        try {
            Class<?> mClass = mPlugInApk.getmDexClassLoader().loadClass(activityName);
            subject = mClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Pluginsloaded() {
        mPlugInApk = PlugInManager.getInstance().getPlugInApk();
        if (subject instanceof IPlugActivity) {
            mIPlugActivity = (IPlugActivity) subject;
            mIPlugActivity.attach((Activity) subject);
        }
    }
}
