package com.hbwang.launcher.model.factory;

import android.content.Context;

import com.hbwang.launcher.model.LauncherModelFrgImpl;
import com.hbwang.launcher.model.product.LauncherModelFrg;

public class LauncherModleFactory {


    private static LauncherModelFrg launcherModelFrg;

    public static LauncherModelFrgImpl initModle(String type, Context context) {
        switch (type) {
            case "":
                if (launcherModelFrg == null) {
                    launcherModelFrg = new LauncherModelFrg(context);
                }
                return launcherModelFrg;
            default:
                return null;
        }
    }
}
