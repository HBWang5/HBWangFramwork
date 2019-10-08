package com.hbwang.player.view.mediaplayer.proxy;

import android.view.SurfaceHolder;

import com.hbwang.player.threadpro.IMediaProCallBack;
import com.hbwang.player.view.mediaplayer.IHBWangMediaPlayer;
import com.hbwang.player.view.mediaplayer.impl.HBWangMediaPlayer;
import com.hbwang.player.listener.IHBWangMediaPlayerListener;


/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/12-15:03
 * 播放器代理
 */
public class HBWangMediaPlayerProxy implements IHBWangMediaPlayer {
    private HBWangMediaPlayer mHBWangMideoPlayer;


    public HBWangMediaPlayerProxy() {
        mHBWangMideoPlayer = new HBWangMediaPlayer();
    }

    @Override
    public void start() {
        mHBWangMideoPlayer.start();
    }

    @Override
    public void pause() {
        mHBWangMideoPlayer.pause();
    }


    @Override
    public void resume() {
        mHBWangMideoPlayer.resume();
    }


    @Override
    public void onDestroy() {
        mHBWangMideoPlayer.onDestroy();
    }

    @Override
    public void savePlayMediaState() {
        mHBWangMideoPlayer.savePlayMediaState();
    }

    @Override
    public void clearPlayMediaState() {
        mHBWangMideoPlayer.clearPlayMediaState();
    }


    @Override
    public void seekTo(long pos) {
        mHBWangMideoPlayer.seekTo(pos);
    }

    @Override
    public void setBufferPercentage(int percent) {
        mHBWangMideoPlayer.setBufferPercentage(percent);
    }


    @Override
    public int getBufferPercentage() {
        return mHBWangMideoPlayer.getBufferPercentage();
    }


    @Override
    public void removeMediaPlayerListener(IHBWangMediaPlayerListener listener) {
        mHBWangMideoPlayer.removeMediaPlayerListener(listener);
    }

    @Override
    public void addMediaPlayerListener(IHBWangMediaPlayerListener listener) {
        mHBWangMideoPlayer.addMediaPlayerListener(listener);
    }

    @Override
    public long getDuration() {
        return mHBWangMideoPlayer.getDuration();
    }

    @Override
    public long getCurrentPosition() {
        return mHBWangMideoPlayer.getCurrentPosition();
    }

    @Override
    public void playMedia(String url) {
        mHBWangMideoPlayer.playMedia(url);
    }

    @Override
    public void bindMediaProManager(IMediaProCallBack iMediaProCallBack) {
        mHBWangMideoPlayer.bindMediaProManager(iMediaProCallBack);
    }

    @Override
    public void onPrepared() {
        mHBWangMideoPlayer.onPrepared();
    }

    @Override
    public void prepare() {
        mHBWangMideoPlayer.prepare();
    }

    @Override
    public void setDisplay(SurfaceHolder display) {
        mHBWangMideoPlayer.setDisplay(display);
    }
}
