package com.hbwang.launcher.presenter.impl;

import android.app.Activity;
import com.hbwang.api.base.model.BaseModel;
import com.hbwang.api.base.presenter.BasePresenter;
import com.hbwang.launcher.model.LauncherModelActImpl;


/**
 * Created by Administrator on 2018/1/3.
 */


public class LauncherPresenterActImpl extends BasePresenter {


    public LauncherPresenterActImpl(Activity context) {
        super(context);
    }


    /**
     * 环境配置
     */
    public void initConfig() {
    }




    /**
     * 初始化绑定Model
     */
    @Override
    public BaseModel bindModel() {
        return new LauncherModelActImpl(getContext());
    }

    @Override
    public void dataCallback(Object result) {

    }



}
