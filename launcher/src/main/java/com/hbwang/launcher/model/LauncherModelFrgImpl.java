package com.hbwang.launcher.model;

import android.content.Context;

import com.hbwang.api.base.model.BaseModel;
import com.hbwang.launcher.presenter.ILauncherPresenterFrgCallback;

import java.util.Map;


/**
 * Created by Administrator on 2018/1/3.
 */
public abstract class LauncherModelFrgImpl extends BaseModel {
    public Context context;

    public LauncherModelFrgImpl(Context context) {
        super(context);
        this.context = context;
    }


    public abstract void particulars(Map carData, ILauncherPresenterFrgCallback iLauncherPrecenterFrgCallback);
}
