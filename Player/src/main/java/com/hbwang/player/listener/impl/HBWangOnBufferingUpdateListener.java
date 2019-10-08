package com.hbwang.player.listener.impl;


import com.hbwang.player.view.mediaplayer.IHBWangMediaPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;


/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/1-15:54
 * 缓冲更新监听回调
 */
public class HBWangOnBufferingUpdateListener implements IMediaPlayer.OnBufferingUpdateListener {
    private IHBWangMediaPlayer mIHBWangMediaPlayer;

    public HBWangOnBufferingUpdateListener(IHBWangMediaPlayer mIHBWangMediaPlayer) {
        this.mIHBWangMediaPlayer = mIHBWangMediaPlayer;
    }

    @Override
    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int percent) {
        mIHBWangMediaPlayer.setBufferPercentage(percent);
    }
}
