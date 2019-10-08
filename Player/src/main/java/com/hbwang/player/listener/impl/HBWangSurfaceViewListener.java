package com.hbwang.player.listener.impl;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.hbwang.player.playerstatus.PlayerStatus;
import com.hbwang.player.view.mediacontroller.IHBWangMediaController;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/25-17:18
 */
public class HBWangSurfaceViewListener implements View.OnTouchListener {
    private GestureDetector mGestureDetector;
    private IHBWangMediaController mHBWangMediaController;
    public HBWangSurfaceViewListener(GestureDetector mGestureDetector) {
        this.mGestureDetector = mGestureDetector;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if (PlayerStatus.PLAYER_GESTURE_STATUS == 0) {
                    mHBWangMediaController.showUI();
                }
                PlayerStatus.PLAYER_GESTURE_STATUS = 0;
                break;
        }
        return mGestureDetector.onTouchEvent(event);
    }


    public void bindMediaController(IHBWangMediaController mHBWangMediaController) {
        this.mHBWangMediaController = mHBWangMediaController;
    }
}
