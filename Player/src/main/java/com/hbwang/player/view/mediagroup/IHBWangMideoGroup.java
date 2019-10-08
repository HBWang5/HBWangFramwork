package com.hbwang.player.view.mediagroup;

import com.hbwang.player.view.mediacontroller.impl.HBWangMediaVideoController;
import com.hbwang.player.view.surfaceview.impl.HBWangSurfaceView;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/12-10:58
 */
public interface IHBWangMideoGroup {
    /**
     * 初始化播放器
     */
    void init();

    /**
     * 绑定播放器视图
     */
    void bindSurfaceView();

    /**
     * 获取当前播放器视图
     */
    HBWangSurfaceView getSurfaceView();

    /**
     * 绑定控制器
     */
    void bindHBWangMediaController(HBWangMediaVideoController mHBWangMediaVideoController);
}
