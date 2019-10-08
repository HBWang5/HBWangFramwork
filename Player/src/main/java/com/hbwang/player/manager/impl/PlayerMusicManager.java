package com.hbwang.player.manager.impl;

import android.content.Intent;
import android.view.ViewGroup;

import com.hbwang.player.manager.IPlayerManager;
import com.hbwang.player.servce.impl.MideoPlayerServce;
import com.hbwang.player.view.mediacontroller.IHBWangMediaController;
import com.hbwang.player.widgetcombination.impl.WidgetMusicCombination;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/15-17:50
 */
public class PlayerMusicManager implements IPlayerManager {

    private WidgetMusicCombination mWidgetMusicCombination;

    /**
     * 初始化播放器
     */
    @Override
    public void bindViewForMediaPlayer(ViewGroup viewGroup) {
        mWidgetMusicCombination = new WidgetMusicCombination();
        mWidgetMusicCombination.initMediaPlayer(viewGroup);
        viewGroup.getContext().startService(new Intent(viewGroup.getContext(), MideoPlayerServce.class));
    }

    /**
     * 播放视频
     */
    @Override
    public void playMedia(String url) {
        mWidgetMusicCombination.playMedia(url);
    }

    /**
     * 获取控制层对象
     */
    @Override
    public IHBWangMediaController getMediaController() {
        return mWidgetMusicCombination.getControllerView();
    }
}
