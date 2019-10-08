package com.hbwang.player.listener.impl;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

import com.hbwang.player.view.mediacontroller.IHBWangMediaController;


/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/25-10:34
 */
public class HBWangMediaProOnTouchListener implements View.OnTouchListener {
    private IHBWangMediaController mIHBWangMediaController;


    public HBWangMediaProOnTouchListener bindMediaController(IHBWangMediaController IHBWangMediaController) {
        mIHBWangMediaController = IHBWangMediaController;
        return this;
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        SeekBar seekBar = (SeekBar) v;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mIHBWangMediaController.pause();
                break;
            case MotionEvent.ACTION_MOVE:
                mIHBWangMediaController.pause();
                break;
            case MotionEvent.ACTION_UP:
                mIHBWangMediaController.seekTo(seekBar.getProgress());
                mIHBWangMediaController.resume();
                break;
        }
        return false;
    }
}
