package com.hbwang.player.view.mediacontroller;

import android.app.Activity;
import android.view.SurfaceHolder;

import com.hbwang.player.threadpro.IMediaProCallBack;
import com.hbwang.player.view.mediagroup.impl.HBWangMediaGroup;
import com.hbwang.player.view.surfaceview.IHBWangSurfaceView;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/12-11:20
 */
public interface IHBWangMediaController {
    void playMedia(String url);

    void surfaceCreated(SurfaceHolder holder);

    void surfaceChanged(SurfaceHolder holder, int format, int width, int height);

    void surfaceDestroyed(SurfaceHolder holder);


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
     * 准备
     */
    void prepare();

    /**
     * 获取播放当前位置
     */
    int getCurrentPosition();

    /**
     * 绑定播放器（进度条）管理器
     */
    void bindMediaProManager(IMediaProCallBack iMediaProCallBack);

    /**
     * 视频移动到指定位置
     */
    void seekTo(int progress);

    IHBWangSurfaceView getSurfaceView();

    void setAppBrightness(int brightness);

    void setVolumeGesture(int volume);

    void showUI();

    void playerFull(Activity context);

    void pullMeasureLayout();

    void initViewConfig();

    void initConstituteView(HBWangMediaGroup mideoGroup);
}
