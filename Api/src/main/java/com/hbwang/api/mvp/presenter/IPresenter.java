package com.hbwang.api.mvp.presenter;

import com.hbwang.api.mvp.view.IUIFrame;

/**
 * Created by Administrator on 2018/1/3.
 */

public interface IPresenter<V extends IUIFrame> {
    //绑定视图
     void attachView(V view);
    //接触绑定
     void dettachView();
    //回调数据
     void dataCallback(Object result);
}
