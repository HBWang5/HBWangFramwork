package com.hbwang.player.manager;

import android.view.ViewGroup;

import com.hbwang.player.view.mediacontroller.IHBWangMediaController;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/1/10-17:23
 * 播放器控制器管理类接口
 */
public interface IPlayerManager {
    void bindViewForMediaPlayer(ViewGroup viewGroup);

    void playMedia(String url);

    IHBWangMediaController getMediaController();
}
