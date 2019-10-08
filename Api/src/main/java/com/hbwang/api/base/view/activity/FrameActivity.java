package com.hbwang.api.base.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.hbwang.api.base.view.BaseView;
import com.hbwang.api.base.view.fragment.BaseFragment;
import com.hbwang.api.frgbridge.FragmentBridge;
import com.hbwang.api.frgbridge.FragmentBridgeImpl;
import com.hbwang.api.mvp.presenter.impl.PresenterCenter;
import com.hbwang.viewbindlib.config.BindViewType;
import com.hbwang.viewbindlib.initbind.InitViewBind;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/1/3.
 */

public abstract class FrameActivity<V extends BaseView,P extends PresenterCenter> extends FragmentActivity{
    private P mPresenter; //P层绑定V
    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定注解
        InitViewBind.getInstance().init(this, BindViewType.LAYOUT);
        if (initFragment() != null) {
            FragmentBridge mFragmentBridgeImpl = new FragmentBridgeImpl(this);
            mFragmentBridgeImpl.init(initFragment(), initFragmentId()).addFragment().commit();           //初始化fragment
        }
        //绑定View
        if (this.mPresenter != null) {
            this.mPresenter.attachView((V)this);
        }
        mPresenter = createPresenter();                     //创建控制器
        initData();
        initView();     //初始化
        initOnClicked();
    }

    /**
     * 获取P层
     */
    public P getPresenter() {
        if (this.mPresenter == null) {
            this.mPresenter = createPresenter();
        }
        return this.mPresenter;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除绑定
        if (this.mPresenter != null) {
            this.mPresenter.dettachView();
            this.mPresenter = null;
        }
    }

    /**
     * 菜单、返回键响应
     */
    @Override
    final public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //调用双击退出函数
            exitBy2Click();
        }
        return false;
    }


    protected void exitBy2Click() {
        Timer mTimer;
        if (!isExit) {
            // 准备退出
            isExit = true;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mTimer = new Timer();
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // 取消退出
                    isExit = false;
                }
                // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
            }, 2000);

        } else {
            finish();
            System.exit(0);
        }
    }


    //创建管理器
    public abstract P createPresenter();

    //初始化布局
    public abstract void initView();


    //初始化Fragment
    public abstract BaseFragment initFragment();

    //初始化布局id
    public abstract int initFragmentId();

    //初始化布局id
    public abstract void initOnClicked();

    //初始化数据
    public abstract void initData();

}
