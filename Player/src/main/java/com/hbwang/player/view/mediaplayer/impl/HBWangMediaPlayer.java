package com.hbwang.player.view.mediaplayer.impl;


import android.view.SurfaceHolder;

import com.hbwang.player.listener.impl.HBWangOnBufferingUpdateListener;
import com.hbwang.player.listener.impl.HBWangOnPreparedListener;
import com.hbwang.player.playerstatus.PlayerStatus;
import com.hbwang.player.playerstatus.PlayerValue;
import com.hbwang.player.threadpro.IMediaProCallBack;
import com.hbwang.player.view.mediaplayer.IHBWangMediaPlayer;
import com.hbwang.player.listener.IHBWangMediaPlayerListener;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;


/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/1/10-17:27
 * 播放器MideoPlayer
 */
public class HBWangMediaPlayer implements IHBWangMediaPlayer {
    /**
     * 由ijkplayer提供，用于播放视频，需要给他传入一个surfaceView
     */
    private IMediaPlayer mMediaPlayer;
    private IMediaProCallBack iMediaProCallBack;
    private int mBufferPercentage;

    public HBWangMediaPlayer() {
        //初始化播放器
        IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
        IjkMediaPlayer.native_setLogLevel(IjkMediaPlayer.IJK_LOG_DEBUG);
        //开启硬解码
        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 1);
        //设置缓冲监听
        ijkMediaPlayer.setOnBufferingUpdateListener(new HBWangOnBufferingUpdateListener(this));
        //设置准备监听
        ijkMediaPlayer.setOnPreparedListener(new HBWangOnPreparedListener(this));
        mMediaPlayer = ijkMediaPlayer;
    }


    @Override
    public void start() {
        PlayerStatus.PLAY_STATUS = PlayerValue.PLAY_PLAYYING;
        mMediaPlayer.start();
    }

    @Override
    public void pause() {
        PlayerStatus.PLAY_STATUS = PlayerValue.PLAY_PAUSE;
        PlayerStatus.PLAYER_PRO_STATUS = false;
        mMediaPlayer.pause();
    }


    @Override
    public void resume() {
        start();
        PlayerStatus.PLAYER_PRO_STATUS = true;
    }


    @Override
    public void onDestroy() {
    }

    @Override
    public void savePlayMediaState() {

    }

    @Override
    public void clearPlayMediaState() {

    }

    @Override
    public void seekTo(long pos) {
        if (pos < 0) {
            mMediaPlayer.seekTo(0);
            return;
        }
        if (pos > mMediaPlayer.getDuration()) {
            mMediaPlayer.seekTo(mMediaPlayer.getDuration());
            return;
        }
        mMediaPlayer.seekTo(pos);
        if (mMediaPlayer.isPlaying()) {
            start();
        }

    }

    @Override
    public void setBufferPercentage(int percent) {
        mBufferPercentage = percent;
        iMediaProCallBack.setBufferPercentage(percent);
    }

    @Override
    public int getBufferPercentage() {
        return mBufferPercentage;
    }


    @Override
    public void removeMediaPlayerListener(IHBWangMediaPlayerListener listener) {

    }

    @Override
    public void addMediaPlayerListener(IHBWangMediaPlayerListener listener) {

    }

    @Override
    public long getDuration() {
        return mMediaPlayer.getDuration();
    }

    @Override
    public long getCurrentPosition() {
        return mMediaPlayer.getCurrentPosition();
    }

    @Override
    public void playMedia(String url) {
        try {
            mMediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void bindMediaProManager(IMediaProCallBack iMediaProCallBack) {
        this.iMediaProCallBack = iMediaProCallBack;
    }

    @Override
    public void onPrepared() {
        //设置进度条长度
        iMediaProCallBack.setInitProConfig((int) getDuration());
        start();
    }

    @Override
    public void prepare() {
        mMediaPlayer.prepareAsync();
    }


    @Override
    public void setDisplay(SurfaceHolder display) {
        mMediaPlayer.setDisplay(display);
    }
}
