package com.hbwang.player.view.surfaceview;


import com.hbwang.player.view.mediacontroller.IHBWangMediaController;
import com.hbwang.player.view.mediaplayer.IHBWangMediaPlayer;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/12-11:20
 */
public interface IHBWangSurfaceView {
    IHBWangMediaPlayer getMideoPlayer();

    void setSyncProgress(long position);

    void bindMediaController(IHBWangMediaController mHBWangMediaController);

}
