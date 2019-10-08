package com.hbwang.hotfix.dexclassloader;

import java.io.File;

import dalvik.system.BaseDexClassLoader;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/9-17:47
 */
public class HBWangDexClassLoader extends BaseDexClassLoader{

    public HBWangDexClassLoader(String dexPath, File optimizedDirectory, String librarySearchPath, ClassLoader parent) {
        super(dexPath, optimizedDirectory, librarySearchPath, parent);
    }


}
