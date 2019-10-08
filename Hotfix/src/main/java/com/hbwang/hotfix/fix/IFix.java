package com.hbwang.hotfix.fix;

import com.hbwang.hotfix.dexlist.DexList;

import java.io.File;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/9-17:55
 */
public interface IFix {
    IFix bindDex(DexList fileDexList);

    void repair();

    void copyDexPrivate(File fileDex);
}
