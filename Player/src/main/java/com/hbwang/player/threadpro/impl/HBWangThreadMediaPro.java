package com.hbwang.player.threadpro.impl;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Message;

import com.hbwang.player.handler.HBWangHandler;
import com.hbwang.player.listener.impl.HBWangMediaProOnTouchListener;
import com.hbwang.player.playerstatus.PlayerStatus;
import com.hbwang.player.threadpro.IMediaProCallBack;
import com.hbwang.player.view.mediacontroller.IHBWangMediaController;
import com.hbwang.player.view.progress.HBWangSeekBar;
import com.hbwang.player.widget.HBWangTextView;

import java.text.SimpleDateFormat;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/22-14:22
 */
public class HBWangThreadMediaPro extends Thread implements IMediaProCallBack {
    private HBWangSeekBar HBWangSeekBar;
    private IHBWangMediaController IHBWangMediaController;
    private HBWangTextView HBWangTextView;
    private final SimpleDateFormat formatter;
    private final SimpleDateFormat formatter_min;

    @SuppressLint("HandlerLeak")
    private HBWangHandler handler = new HBWangHandler() {
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            HBWangTextView.setText((HBWangSeekBar.getMax() > 216000 ? formatter.format(HBWangSeekBar.getMax()) : formatter_min.format(HBWangSeekBar.getMax()))
                    + "/" + (HBWangSeekBar.getMax() > 216000 ? formatter.format(msg.what) : formatter_min.format(msg.what))
            );
        }
    };

    @SuppressLint("SimpleDateFormat")
    public HBWangThreadMediaPro() {
        formatter = new SimpleDateFormat("HH:mm:ss");
        formatter_min = new SimpleDateFormat("mm:ss");
    }

    public void bind(HBWangSeekBar HBWangSeekBar, HBWangTextView HBWangTextView, IHBWangMediaController IHBWangMediaController) {
        this.HBWangSeekBar = HBWangSeekBar;
        this.IHBWangMediaController = IHBWangMediaController;
        this.HBWangTextView = HBWangTextView;
        handler.bindContext((Activity) HBWangSeekBar.getContext());
    }

    @Override
    public void run() {
        super.run();
        while (HBWangSeekBar.getProgress() <= HBWangSeekBar.getMax()) {
            if (PlayerStatus.PLAYER_PRO_STATUS) {
                //获取音乐当前播放的位置
                int position = IHBWangMediaController.getCurrentPosition();
                IHBWangMediaController.getSurfaceView().setSyncProgress(position);
                //设置进度
                HBWangSeekBar.setProgress(position);
                if (position % 60 == 0) {
                    handler.sendEmptyMessage(position);
                }
            }
        }
    }

    /**
     * SeekBar控制初始化
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void setInitProConfig(int duration) {
        HBWangSeekBar.setMax(duration);                                                               //设置进度条最大值
        HBWangSeekBar.setOnTouchListener(new HBWangMediaProOnTouchListener().bindMediaController(IHBWangMediaController));//设置监听
    }

    @Override
    public void setBufferPercentage(int percent) {
        HBWangSeekBar.setSecondaryProgress(HBWangSeekBar.getMax() * percent / 100);
    }
}
