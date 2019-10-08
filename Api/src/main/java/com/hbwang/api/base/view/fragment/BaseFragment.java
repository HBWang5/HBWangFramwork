package com.hbwang.api.base.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hbwang.api.base.view.BaseView;
import com.hbwang.api.mvp.presenter.impl.PresenterCenter;

/**
 * 框架类
 *
 * @param <P>
 * @param <V>
 */

public abstract class BaseFragment<V extends BaseView,P extends PresenterCenter> extends FrameFragment<P, V> {

    private View contentView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView = inflater.inflate(bindLayoutId(), container, false);
        return contentView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initView(contentView);     //初始化
        initOnclicked();
    }

    public void errorView(String error){
//        getContentView().getWindow().getDecorView();
    }
    //初始化数据
    protected abstract void initData();

    //初始化控件监听
    public abstract void initOnclicked();

    //初始化布局
    public abstract void initView(View contentView);


    public View getContentView() {
        return contentView;
    }


    //fragment布局文件的id
    public abstract int bindLayoutId();

}
