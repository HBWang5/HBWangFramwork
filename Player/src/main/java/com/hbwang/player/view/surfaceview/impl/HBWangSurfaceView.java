package com.hbwang.player.view.surfaceview.impl;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hbwang.player.listener.IHBWangVideoGestureListener;
import com.hbwang.player.listener.impl.HBWangOnGestureListener;
import com.hbwang.player.listener.impl.HBWangSurfaceViewListener;
import com.hbwang.player.playerstatus.PlayerStatus;
import com.hbwang.player.tools.BrightnessTools;
import com.hbwang.player.view.mediacontroller.IHBWangMediaController;
import com.hbwang.player.view.mediacontroller.constitute.impl.ConstituteVideoView;
import com.hbwang.player.view.mediaplayer.IHBWangMediaPlayer;
import com.hbwang.player.view.mediaplayer.proxy.HBWangMediaPlayerProxy;
import com.hbwang.player.view.surfaceview.ISurfaceViewCallBack;
import com.hbwang.player.view.surfaceview.IHBWangSurfaceView;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/1/10-17:28
 * 播放界面
 * 手势控制逻辑
 */
public class HBWangSurfaceView extends SurfaceView implements IHBWangSurfaceView, ISurfaceViewCallBack, IHBWangVideoGestureListener {

    private HBWangMediaPlayerProxy mHBWangMediaPlayerProxy;
    private int brightness = 125;
    private long oldProgress;
    private long newProgress;
    private IHBWangMediaController mHBWangMediaController;
    private HBWangSurfaceViewListener HBWangSurfaceViewListener;


    public HBWangSurfaceView(Context context) {
        super(context);
        init();
    }


    public HBWangSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HBWangSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        //设置手势监听
        GestureDetector mGestureDetector = new GestureDetector(new HBWangOnGestureListener(this));
        HBWangSurfaceViewListener = new HBWangSurfaceViewListener(mGestureDetector);
        //设置点击滑动监听
        setOnTouchListener(HBWangSurfaceViewListener);
        //取消长按，不然会影响滑动
        mGestureDetector.setIsLongpressEnabled(false);
        //设置app常亮
        BrightnessTools.getInstance().setOftenBrightness((Activity) getContext());

    }

    /**
     * 显示
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mHBWangMediaPlayerProxy.setDisplay(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    public void addCallback(HBWangMediaPlayerProxy HBWangMediaPlayerProxy) {
        this.mHBWangMediaPlayerProxy = HBWangMediaPlayerProxy;
        getHolder().addCallback(this);
    }

    @Override
    public IHBWangMediaPlayer getMideoPlayer() {
        return mHBWangMediaPlayerProxy;
    }

    /**
     * 亮度手势调节
     */
    @Override
    public void onBrightnessGesture(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (distanceY > 0) {
            BrightnessTools.getInstance().setAppBrightness(brightness > 255 ? 255 : brightness++, (Activity) getContext());
            mHBWangMediaController.setAppBrightness(brightness > 255 ? 100 : (int) (brightness++ / 2.55));
        } else {
            BrightnessTools.getInstance().setAppBrightness(brightness < 0 ? 0 : brightness--, (Activity) getContext());
            mHBWangMediaController.setAppBrightness(brightness < 0 ? 0 : (int) (brightness-- / 2.55));
        }

    }

    /**
     * 音量手势调节
     */
    @Override
    public void onVolumeGesture(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float e_one_y = e1.getY() ;
        float e_two_y = e2.getY() ;
        int value = getHeight() / BrightnessTools.getInstance().getMaxVolume();
        int volume = (int) ((e_one_y - e_two_y) / (value * 2));
        BrightnessTools.getInstance().setVolumeGesture(volume);
        mHBWangMediaController.setVolumeGesture((int) ((float) BrightnessTools.getInstance().getStreamVolume() / (float) BrightnessTools.getInstance().getMaxVolume() * 100));
    }

    /**
     * 快进手势调节
     */
    @Override
    public void onFF_REWGesture(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float offset = e2.getX() - e1.getX();
        if (offset > 0) {
            newProgress = (long) (oldProgress + offset / getWidth() * getMideoPlayer().getDuration());
            if (newProgress > getMideoPlayer().getDuration()) {
                newProgress = getMideoPlayer().getDuration();
            }
        } else {
            newProgress = (long) (oldProgress + offset / getWidth() * getMideoPlayer().getDuration());
            if (newProgress < 0) {
                newProgress = 0;
            }
        }
        ConstituteVideoView.getInstance().showBelow();
        getMideoPlayer().seekTo(newProgress);

    }

    /**
     * 按下时重新更新配置
     */
    @Override
    public void resetConfig() {
        oldProgress = newProgress;
    }

    /**
     * 同步进度
     */
    @Override
    public void setSyncProgress(long position) {
        if (PlayerStatus.PLAYER_GESTURE_STATUS == 1) {
            return;
        }
        oldProgress = position;
    }

    /**
     * 绑定控制器
     */
    @Override
    public void bindMediaController(IHBWangMediaController mHBWangMediaController) {
        this.mHBWangMediaController = mHBWangMediaController;
        HBWangSurfaceViewListener.bindMediaController(mHBWangMediaController);
    }
}
