package com.hbwang.player.manager.impl;


import android.view.ViewGroup;

import com.hbwang.player.manager.IPlayerManager;
import com.hbwang.player.view.mediacontroller.IHBWangMediaController;
import com.hbwang.player.widgetcombination.impl.WidgetVideoCombination;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/1/10-17:40
 * 播放器管理器（用于交互）
 */
public class PlayerVideoManager implements IPlayerManager {

    private WidgetVideoCombination mWidgetVideoCombination;

    /**
     * 初始化播放器
     */
    @Override
    public void bindViewForMediaPlayer(ViewGroup viewGroup) {
        mWidgetVideoCombination = new WidgetVideoCombination();
        mWidgetVideoCombination.initMediaPlayer(viewGroup);
    }

    /**
     * 播放音频
     */
    @Override
    public void playMedia(String url) {
        mWidgetVideoCombination.playMedia(url);
    }

    /**
     * 获取控制层对象
     */
    @Override
    public IHBWangMediaController getMediaController() {
        return mWidgetVideoCombination.getControllerView();
    }


}
