package com.hbwang.player.listener;

import android.view.MotionEvent;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/25-16:53
 */
public interface IHBWangVideoGestureListener {
    //亮度手势，手指在Layout左半部上下滑动时候调用
     void onBrightnessGesture(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);

    //音量手势，手指在Layout右半部上下滑动时候调用
     void onVolumeGesture(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);

    //快进快退手势，手指在Layout左右滑动的时候调用
     void onFF_REWGesture(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);

    void resetConfig();

}
