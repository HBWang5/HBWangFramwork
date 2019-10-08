package com.hbwang.player.view.mediaplayer;

import android.view.SurfaceHolder;

import com.hbwang.player.threadpro.IMediaProCallBack;
import com.hbwang.player.listener.IHBWangMediaPlayerListener;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/1/10-17:46
 */
public interface IHBWangMediaPlayer {
    /**
     * 显示
     */
    void setDisplay(SurfaceHolder display);

    /**
     * 准备播放器
     */
    void prepare();

    /**
     * 开始播放
     */
    void start();

    /**
     * 暂停播放
     */
    void pause();


    /**
     * 恢复播放
     */
    void resume();


    /**
     * 销毁
     */
    void onDestroy();


    /**
     * 保存播放状态和进度
     */
    void savePlayMediaState();


    /**
     * 清除播放状态和进度
     */
    void clearPlayMediaState();


    /**
     * 跳到指定的播放位置
     */
    void seekTo(long pos);


    /**
     * 设置缓冲百分比
     */
    void setBufferPercentage(int percent);

    /**
     * 获取缓冲百分比
     */
    int getBufferPercentage();

    /**
     * 移除播放状态监听器
     */
    void removeMediaPlayerListener(IHBWangMediaPlayerListener listener);

    /**
     * 添加播放状态监听器
     */
    void addMediaPlayerListener(IHBWangMediaPlayerListener listener);

    /**
     * 获取总时长
     */
    long getDuration();

    /**
     * 获取当前位置
     */
    long getCurrentPosition();

    /**
     * 播放视频
     */
    void playMedia(String url);

    /**
     * 绑定播放管理器
     */
    void bindMediaProManager(IMediaProCallBack iMediaProCallBack);

    /**
     * 播放器初始化准备完成
     */
    void onPrepared();
}
