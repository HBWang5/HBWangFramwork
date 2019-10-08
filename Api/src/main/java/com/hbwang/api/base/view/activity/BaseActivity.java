package com.hbwang.api.base.view.activity;


import com.hbwang.api.base.view.BaseView;
import com.hbwang.api.mvp.presenter.impl.PresenterCenter;

/**
 * 框架类
 * @param <V,P>
 */
public abstract class BaseActivity<V extends BaseView,P extends PresenterCenter> extends FrameActivity<V,P> {



}
