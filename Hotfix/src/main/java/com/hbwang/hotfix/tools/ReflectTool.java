package com.hbwang.hotfix.tools;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/9-17:51
 */
public class ReflectTool {
    private static ReflectTool mReflectTool;

    private ReflectTool() {
    }

    public static synchronized ReflectTool getInstance(){
        if (mReflectTool == null) {
            mReflectTool = new ReflectTool();
        }
        return mReflectTool;
    }


}
