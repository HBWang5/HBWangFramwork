package com.hbwang.launcher.view.fragment.launcher;


import android.content.res.Configuration;
import android.view.View;

import com.hbwang.api.base.view.fragment.BaseFragment;
import com.hbwang.hbwangframwork.R;
import com.hbwang.launcher.presenter.impl.LauncherPresenterFrgImpl;
import com.hbwang.launcher.ui.ILauncherFragmentUI;
import com.hbwang.player.manager.IPlayerManager;
import com.hbwang.player.manager.impl.PlayerVideoManager;
import com.hbwang.player.view.mediacontroller.IHBWangMediaController;


public class WZLauncherFragment extends BaseFragment<ILauncherFragmentUI,LauncherPresenterFrgImpl> implements ILauncherFragmentUI,LauncherFrgCallBack {


    /**
     * 创建P
     */
    @Override
    public LauncherPresenterFrgImpl createPresenter() {

        return new LauncherPresenterFrgImpl(getAtyContext());                                       //初始化控制器
    }

    /**
     * 绑定P
     */
    @Override
    public ILauncherFragmentUI createView() {
        return this;
    }

    /**
     * 初始化View
     */
    @Override
    public void initView(View contentView) {
        IPlayerManager playerVideoManager = new PlayerVideoManager();
        playerVideoManager.bindViewForMediaPlayer(getContentView().findViewById(R.id.relativeLayout));
        IHBWangMediaController hbwangMediaController = playerVideoManager.getMediaController();
        playerVideoManager.playMedia("http://vjs.zencdn.net/v/oceans.mp4");
        hbwangMediaController.prepare();
        hbwangMediaController.start();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
    }


    /**
     * 初始化View监听
     */
    @Override
    public void initOnclicked() {

    }

    /**
     * 绑定FragmentLayout
     */
    @Override
    public int bindLayoutId() {
        return R.layout.fragment_main;
    }



}
