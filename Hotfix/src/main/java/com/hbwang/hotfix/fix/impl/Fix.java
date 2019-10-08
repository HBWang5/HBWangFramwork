package com.hbwang.hotfix.fix.impl;

import com.hbwang.hotfix.dexlist.DexList;
import com.hbwang.hotfix.fix.IFix;
import com.hbwang.hotfix.tools.ReflectTool;

import java.io.File;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/9-17:55
 */
public class Fix implements IFix {

    private final ReflectTool mReflectTool;

    public Fix() {
        mReflectTool = ReflectTool.getInstance();
    }


    @Override
    public IFix bindDex(DexList fileDexList) {
        return this;
    }

    @Override
    public void repair() {

    }

    @Override
    public void copyDexPrivate(File fileDex) {

    }
}
