package com.hbwang.pluginlib.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

import com.hbwang.pluginlib.pluginapk.PlugInApk;

import dalvik.system.DexClassLoader;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/20-16:01
 */
public interface IPlugInManager {


    /**
     * 加载插件apk
     */
    void initContext(Context context);

    /**
     * 加载插件apk
     */
    void loadApk(String apkPath);

    /**
     * 创建加载插件Classloader
     */
    DexClassLoader createDexClassLoader(String apkPath);

    /**
     * 创建AssetManager
     */
    AssetManager createAssetManager(String apkPath);

    /**
     * 加载Resouce
     */
    Resources createResouce(AssetManager assetManager);

    /**
     * 获取PlugInApk
     */
    PlugInApk getPlugInApk();
}
