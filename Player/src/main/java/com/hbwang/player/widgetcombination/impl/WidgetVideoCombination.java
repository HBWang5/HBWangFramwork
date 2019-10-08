package com.hbwang.player.widgetcombination.impl;


import android.app.Activity;
import android.content.res.Configuration;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.hbwang.player.view.mediacontroller.IHBWangMediaController;
import com.hbwang.player.view.mediacontroller.impl.HBWangMediaVideoController;
import com.hbwang.player.view.mediagroup.impl.HBWangMediaGroup;
import com.hbwang.player.widgetcombination.IWidgetCombination;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/13-13:59
 * 初始化层级控制（组合）
 */
public class WidgetVideoCombination extends IWidgetCombination {

    private HBWangMediaVideoController mHBWangMediaVideoController;
    private HBWangMediaGroup mTideoGroup;


    /**
     * 背景层（覆盖于控制层之上）
     */
    @Override
    public void bindBackgroundView() {
    }

    /**
     * 插件层试图（广告，弹幕等，覆盖于控制层之上）
     */
    @Override
    public void bindPluginView() {

    }

    /**
     * 播放器层试图(最底层)
     */
    @Override
    public void bindMideoGroup(ViewGroup viewGroup) {
        mTideoGroup = new HBWangMediaGroup(activity);
        //获取设置的配置信息
        Configuration mConfiguration = activity.getResources().getConfiguration();
        //获取屏幕方向
        int ori = mConfiguration.orientation;
        ViewGroup.LayoutParams layoutParams = ori == Configuration.ORIENTATION_LANDSCAPE ? new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT) : new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 600);
        viewGroup.addView(mTideoGroup, layoutParams);
        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            ((Activity) mTideoGroup.getContext()).getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            ((Activity) mTideoGroup.getContext()).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

    }



    /**
     * 绑定SurfaceView
     */
    @Override
    public void bindSurfaceView() {
        //绑定播放器视图
        mTideoGroup.bindSurfaceView();
        //控制层绑定播放器层
        mTideoGroup.bindHBWangMediaController(mHBWangMediaVideoController);
    }

    /**
     * 播放视频地址
     */
    @Override
    public void playMedia(String url) {
        mHBWangMediaVideoController.playMedia(url);
    }


    /**
     * 获取控制层
     */
    @Override
    public IHBWangMediaController getControllerView() {
        return mHBWangMediaVideoController;
    }

    @Override
    public void initController() {
        mHBWangMediaVideoController = new HBWangMediaVideoController(activity);
    }
}
