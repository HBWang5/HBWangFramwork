package com.hbwang.player.view.mediagroup.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.hbwang.player.view.mediacontroller.impl.HBWangMediaVideoController;
import com.hbwang.player.view.mediagroup.IHBWangMideoGroup;
import com.hbwang.player.view.mediaplayer.proxy.HBWangMediaPlayerProxy;
import com.hbwang.player.view.surfaceview.impl.HBWangSurfaceView;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/1/10-17:43
 * 播放器
 */

public class HBWangMediaGroup extends FrameLayout implements IHBWangMideoGroup {
    private HBWangSurfaceView mSurfaceView;
    public HBWangMediaGroup(Context context) {
        super(context);
    }

    public HBWangMediaGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HBWangMediaGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化播放器
     */
    @Override
    public void init() {


    }


    @Override
    public void bindSurfaceView() {
        //初始化surfaceView展示
        mSurfaceView = new HBWangSurfaceView(getContext());
        //添加布局
        this.addView(mSurfaceView);
        //初始化播放器代理
        HBWangMediaPlayerProxy mHBWangMediaPlayerProxy = new HBWangMediaPlayerProxy();
        //surfaceView展示
        mSurfaceView.addCallback(mHBWangMediaPlayerProxy);
    }

    @Override
    public HBWangSurfaceView getSurfaceView() {
        return mSurfaceView;
    }

    /**
     * 绑定控制器
     */
    @Override
    public void bindHBWangMediaController(HBWangMediaVideoController mHBWangMediaVideoController) {
        this.addView(mHBWangMediaVideoController);
        mSurfaceView.bindMediaController(mHBWangMediaVideoController);
        mHBWangMediaVideoController.initConstituteView(this);
    }

}
