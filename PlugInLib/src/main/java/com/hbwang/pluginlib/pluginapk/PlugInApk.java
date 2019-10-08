package com.hbwang.pluginlib.pluginapk;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/20-15:57
 */
public class PlugInApk {
    private PackageInfo mPackageInfo;
    private Resources mResources;
    private AssetManager mAssetManager;
    private DexClassLoader mDexClassLoader;

    public PlugInApk(PackageInfo mPackageInfo, Resources mResources, DexClassLoader mDexClassLoader) {
        this.mPackageInfo = mPackageInfo;
        this.mResources = mResources;
        this.mAssetManager = mResources.getAssets();
        this.mDexClassLoader = mDexClassLoader;
    }

    public DexClassLoader getmDexClassLoader() {
        return mDexClassLoader;
    }

    public PackageInfo getmPackageInfo() {
        return mPackageInfo;
    }

    public Resources getmResources() {
        return mResources;
    }

    public AssetManager getmAssetManager() {
        return mAssetManager;
    }
}
