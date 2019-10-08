package com.hbwang.api.mvp.presenter.impl;

import com.hbwang.api.mvp.presenter.IPresenter;
import com.hbwang.api.mvp.view.IUIFrame;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/1/3.
 */

public abstract class PresenterCenter<V extends IUIFrame> implements IPresenter<V> {
    private WeakReference<V> view;

    /**
     * 绑定View
     *
     */
    @Override
    public void attachView(V view) {
        this.view = new WeakReference<>(view);
    }

    /**
     * 解除绑定
     */
    @Override
    public void dettachView() {
        this.view = null;
    }

    /**
     * 用于检查View是否为空对象
     *
     */
    public boolean isAttachView() {
        return this.view != null && this.view.get() != null;
    }

    public V getView() {
        if (this.view != null) {
            return this.view.get();
        }
        return null;
    }


}
