package com.hbwang.pluginlib.manager.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import com.hbwang.pluginlib.manager.IPlugInManager;
import com.hbwang.pluginlib.pluginapk.PlugInApk;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/20-15:59
 * 插件管理器
 */
public class PlugInManager implements IPlugInManager {
    @SuppressLint("StaticFieldLeak")
    private static PlugInManager mPlugInManager;
    private Context mContext;
    private PlugInApk mPlugInApk;

    private PlugInManager() {
    }

    public static synchronized PlugInManager getInstance() {
        if (mPlugInManager == null) {
            mPlugInManager = new PlugInManager();
        }
        return mPlugInManager;
    }


    @Override
    public void initContext(Context context) {
        mContext = context.getApplicationContext();
    }

    @Override
    public void loadApk(String apkPath) {
        PackageInfo packageInfo = mContext.getPackageManager().getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);
        if (packageInfo == null) {
            return;
        }
        DexClassLoader dexClassLoader = createDexClassLoader(apkPath);
        AssetManager assetManager = createAssetManager(apkPath);
        Resources resources = createResouce(assetManager);
        mPlugInApk = new PlugInApk(packageInfo, resources, dexClassLoader);
    }

    @Override
    public DexClassLoader createDexClassLoader(String apkPath) {
        File file = mContext.getDir("dex", Context.MODE_PRIVATE);
        return new DexClassLoader(apkPath, file.getAbsolutePath(), null, mContext.getClassLoader());
    }

    @SuppressLint("PrivateApi")
    @Override
    public AssetManager createAssetManager(String apkPath) {
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager,apkPath);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Resources createResouce(AssetManager assetManager) {
        Resources resources = mContext.getResources();
        return new Resources(assetManager,resources.getDisplayMetrics(),resources.getConfiguration());
    }

    @Override
    public PlugInApk getPlugInApk() {
        return mPlugInApk;
    }
}
