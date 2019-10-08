package com.hbwang.launcher.presenter.impl;

import android.app.Activity;
import android.content.Intent;

import com.hbwang.api.base.model.BaseModel;
import com.hbwang.api.base.presenter.BasePresenter;
import com.hbwang.api.config.Config;
import com.hbwang.api.utils.IsInternetConnected;
import com.hbwang.api.utils.HBWangLogUtils;
import com.hbwang.launcher.view.activity.LauncherActivity;

public class NavigationPresenterActImpl extends BasePresenter {
    public NavigationPresenterActImpl(Activity context) {
        super(context);
        initLog();
        isNet(context);
    }

    /**
     * 添加Log开关
     */
    private void initLog() {
        HBWangLogUtils.isShowLog =
                true;
    }

    /**
     * 查看是否有网络
     */
    private void isNet(Activity context) {
        Config.IS_INTERNET_CONNECTED = IsInternetConnected.isNetworkAvalible(context);
        if (Config.IS_INTERNET_CONNECTED) {
            Intent intent = new Intent(context, LauncherActivity.class);
            intent.putExtra("isNet", true);
            context.startActivity(intent);
        } else {
            Intent intent = new Intent(context, LauncherActivity.class);
            intent.putExtra("isNet", false);
            context.startActivity(intent);
        }
    }

    @Override
    public BaseModel bindModel() {
        return null;
    }


    @Override
    public void dataCallback(Object result) {

    }
}
