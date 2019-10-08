package com.hbwang.player.listener.impl;

import com.hbwang.player.view.mediaplayer.IHBWangMediaPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/1-16:18
 */
public class HBWangOnPreparedListener implements IMediaPlayer.OnPreparedListener{

    private IHBWangMediaPlayer mHBWangMideoPlayer;

    public HBWangOnPreparedListener(IHBWangMediaPlayer mHBWangMideoPlayer) {
        this.mHBWangMideoPlayer = mHBWangMideoPlayer;
    }

    @Override
    public void onPrepared(IMediaPlayer iMediaPlayer) {

        mHBWangMideoPlayer.onPrepared();
    }
}
