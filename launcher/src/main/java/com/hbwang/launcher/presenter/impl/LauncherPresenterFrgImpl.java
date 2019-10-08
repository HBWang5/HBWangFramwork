package com.hbwang.launcher.presenter.impl;

import android.content.Context;
import android.widget.Toast;

import com.hbwang.api.base.model.BaseModel;
import com.hbwang.api.base.presenter.BasePresenter;
import com.hbwang.launcher.model.factory.LauncherModleFactory;
import com.hbwang.launcher.presenter.ILauncherPresenterFrgCallback;



/**
 * Created by Administrator on 2018/1/3.
 */


public class LauncherPresenterFrgImpl extends BasePresenter implements ILauncherPresenterFrgCallback {

    public LauncherPresenterFrgImpl(Context context) {
        super(context);
    }

    /**
     * 绑定Model
     */
    @Override
    public BaseModel bindModel() {
        return LauncherModleFactory.initModle("", getContext());          //初始化Model
    }


    /**
     * 数据回调
     */
    @Override
    public void dataCallback(Object result) {
    }


    @Override
    public void replace(Object obj) {

    }

    @Override
    public void callBackError(String str) {
        Toast.makeText(getContext(),str, Toast.LENGTH_SHORT).show();
    }

}
