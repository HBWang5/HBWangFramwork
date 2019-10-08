package com.hbwang.pluginlib.activity;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hbwang.pluginlib.config.PlugInConfig;
import com.hbwang.pluginlib.manager.impl.PlugInManager;
import com.hbwang.pluginlib.pluginapk.PlugInApk;
import com.hbwang.pluginlib.pluglifecycle.IPlugActivity;
import com.hbwang.pluginlib.proxy.impl.PlugProxyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/26-11:24
 */
public abstract class ProxyActivityBase extends Activity{
    private IPlugActivity mProxyActivity;
    private PlugInApk mPlugInApk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlugInApk = PlugInManager.getInstance().getPlugInApk();
        PlugProxyInvocationHandler plugProxyInvocationHandler = new PlugProxyInvocationHandler();
        plugProxyInvocationHandler.bindPlugInApk(getIntent().getStringExtra(PlugInConfig.PLUGIN_NAME_KEY));
        mProxyActivity = (IPlugActivity) Proxy.newProxyInstance(plugProxyInvocationHandler.getClass().getClassLoader(),
                        plugProxyInvocationHandler.getClass().getInterfaces(), plugProxyInvocationHandler);
        Bundle bundle = new Bundle();
        bundle.putInt(PlugInConfig.FROM_KEY, PlugInConfig.FROM_EXTERNAL);
        mProxyActivity.onCreate(bundle);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mProxyActivity.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mProxyActivity.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mProxyActivity.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProxyActivity.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mProxyActivity.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mProxyActivity.onStop();
    }

    @Override
    public Resources getResources() {
        return mPlugInApk != null ? mPlugInApk.getmResources() : super.getResources();
    }

    @Override
    public AssetManager getAssets() {
        return mPlugInApk != null ? mPlugInApk.getmAssetManager() :super.getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mPlugInApk != null ? mPlugInApk.getmDexClassLoader() :super.getClassLoader();
    }
}
