package com.hbwang.api.permission.manager.impl;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.hbwang.api.permission.manager.IPermissionManager;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/24-16:35
 */
public class PermissionManagerImpl implements IPermissionManager{
    @Override
    public boolean jurisdictionDetection(Context context, @NonNull String... perms) {
        return EasyPermissions.hasPermissions(context, perms);
    }

    @Override
    public void jurisdictionApply(@NonNull Context context, @NonNull String rationale, int requestCode, @NonNull String... perms) {
        EasyPermissions.requestPermissions((Activity) context, rationale,requestCode,perms);
    }

}
