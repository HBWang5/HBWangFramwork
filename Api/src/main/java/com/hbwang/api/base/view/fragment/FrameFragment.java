package com.hbwang.api.base.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.hbwang.api.base.view.BaseView;
import com.hbwang.api.mvp.presenter.impl.PresenterCenter;
import com.hbwang.api.mvp.view.IUICallBack;
import com.hbwang.api.mvp.view.IUIFrame;

/**
 * Created by Administrator on 2018/1/3.
 */

public abstract class FrameFragment<P extends PresenterCenter, V extends BaseView> extends Fragment {
    private P presenter;



        @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (this.presenter == null){
            this.presenter = createPresenter();//  创建控制器
        }
        if (this.presenter != null){
            this.presenter.attachView((V)createView());    //绑定
        }

    }

    public abstract P createPresenter();

    public abstract V createView();


    public FragmentActivity getAtyContext() {
        return getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.presenter != null) {
            this.presenter.dettachView();   //解除绑定
            this.presenter = null;
        }
    }
}
