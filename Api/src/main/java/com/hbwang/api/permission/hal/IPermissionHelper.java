package com.hbwang.api.permission.hal;


import android.content.Context;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/24-16:53
 */
public interface IPermissionHelper {
    /**
     * 申请权限
     */
    IPermissionHelper jurisdictionApply(String Permission);
    /**
     * 提交
     */
    void submit(Context context);

}
