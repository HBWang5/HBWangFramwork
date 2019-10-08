package com.hbwang.player.view.mediacontroller.constitute.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hbwang.player.R;
import com.hbwang.player.handler.HBWangHandler;
import com.hbwang.player.playerstatus.PlayerStatus;
import com.hbwang.player.threadpro.impl.HBWangThreadMediaPro;
import com.hbwang.player.view.mediacontroller.IHBWangMediaController;
import com.hbwang.player.view.mediacontroller.constitute.IConstituteView;
import com.hbwang.player.view.progress.HBWangSeekBar;
import com.hbwang.player.view.progress.VolumeBrightnessBar;
import com.hbwang.player.widget.HBWangImageView;
import com.hbwang.player.widget.HBWangLinearLayout;
import com.hbwang.player.widget.HBWangTextView;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/13-17:51
 * 控制层组件整合
 */
public class ConstituteVideoView implements IConstituteView {


    @SuppressLint("StaticFieldLeak")
    private static ConstituteVideoView mConstituteVideoView;
    private ViewGroup mViewGroup;
    private HBWangLinearLayout mHBWangLinearLayout;
    private VolumeBrightnessBar mBrightnessBar;
    private VolumeBrightnessBar mVolumeBar;


    @SuppressLint("HandlerLeak")
    private HBWangHandler mHBWangHandler = new HBWangHandler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            setVisibiLityAll(false);
        }
    };

    public void setVisibiLity() {
        if (PlayerStatus.PLAYER_CONTROLLER_VIEW_VISIBLE) {
            setVisibiLityAll(false);
        } else {
            setVisibiLityAll(true);
        }
        mHBWangHandler.removeMessages(0);
        mHBWangHandler.sendEmptyMessageDelayed(0, 5000);
    }

    private void setVisibiLityAll(boolean isVisibiLity) {
        PlayerStatus.PLAYER_CONTROLLER_VIEW_VISIBLE = isVisibiLity;
        mHBWangLinearLayout.setVisibility(isVisibiLity ? View.VISIBLE : View.GONE);
        mVolumeBar.setVisibility(isVisibiLity ? View.VISIBLE : View.GONE);
        mBrightnessBar.setVisibility(isVisibiLity ? View.VISIBLE : View.GONE);

    }

    private ConstituteVideoView() {
    }

    public static synchronized ConstituteVideoView getInstance() {
        if (mConstituteVideoView == null) {
            mConstituteVideoView = new ConstituteVideoView();
        }
        return mConstituteVideoView;
    }

    @Override
    public IConstituteView init(ViewGroup viewGroup) {
        mHBWangHandler.bindContext((Activity) viewGroup.getContext());
        this.mViewGroup = viewGroup;
        return this;
    }


    @Override
    public IConstituteView addBelowColumnView() {


        mHBWangLinearLayout = new HBWangLinearLayout(mViewGroup.getContext());
        mHBWangLinearLayout.setWeightSum(11);
        RelativeLayout.LayoutParams hbwangLinearLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        hbwangLinearLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        hbwangLinearLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        hbwangLinearLayoutParams.setMargins(0, 0, 0, 10);
        mViewGroup.addView(mHBWangLinearLayout, hbwangLinearLayoutParams);


        HBWangImageView hbwangImagePauseView = new HBWangImageView(mViewGroup.getContext());
        hbwangImagePauseView.setId(R.id.player_pause);
        mHBWangLinearLayout.addView(hbwangImagePauseView);
        hbwangImagePauseView.setImageResource(R.drawable.pause);
        LinearLayout.LayoutParams hbwangImagePauseViewParams = new LinearLayout.LayoutParams(0, 50, 0.5f);
        hbwangImagePauseViewParams.leftMargin = 10;
        hbwangImagePauseViewParams.gravity = Gravity.CENTER;
        hbwangImagePauseView.setLayoutParams(hbwangImagePauseViewParams);

        HBWangSeekBar mHBWangSeekBar = new HBWangSeekBar(mViewGroup.getContext());
        mHBWangLinearLayout.addView(mHBWangSeekBar);
        LinearLayout.LayoutParams hbwangSeekBarParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 9.0f);
        mHBWangSeekBar.setLayoutParams(hbwangSeekBarParams);

        HBWangTextView mHBWangTextView = new HBWangTextView(mViewGroup.getContext());
        mHBWangTextView.setTextSize(5);
        mHBWangLinearLayout.addView(mHBWangTextView);
        mHBWangTextView.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams hbwangTextViewParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
        hbwangTextViewParams.gravity = Gravity.CENTER;
        mHBWangTextView.setLayoutParams(hbwangTextViewParams);

        HBWangImageView HBWangImageViewFull = new HBWangImageView(mViewGroup.getContext());
        HBWangImageViewFull.setId(R.id.player_full);
        mHBWangLinearLayout.addView(HBWangImageViewFull);
        HBWangImageViewFull.setImageResource(R.drawable.full);
        LinearLayout.LayoutParams hbwangImageViewFullParams = new LinearLayout.LayoutParams(0, 50, 0.5f);
        hbwangImageViewFullParams.rightMargin = 10;
        hbwangImageViewFullParams.gravity = Gravity.CENTER;
        HBWangImageViewFull.setLayoutParams(hbwangImageViewFullParams);

        HBWangThreadMediaPro HBWangThreadMediaPro = new HBWangThreadMediaPro();
        HBWangThreadMediaPro.bind(mHBWangSeekBar, mHBWangTextView, (IHBWangMediaController) mViewGroup);
        ((IHBWangMediaController) mViewGroup).bindMediaProManager(HBWangThreadMediaPro);
        HBWangThreadMediaPro.start();

        mHBWangHandler.sendEmptyMessageDelayed(0, 5000);

        return this;
    }

    @Override
    public IConstituteView addTopColumnView() {
        return this;
    }

    @Override
    public IConstituteView addLeftColumnView() {

        mVolumeBar = new VolumeBrightnessBar(mViewGroup.getContext()).setStyle(0);
        RelativeLayout.LayoutParams volumeBrightnessBarParams = new RelativeLayout.LayoutParams(100, 300);
        volumeBrightnessBarParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        volumeBrightnessBarParams.addRule(RelativeLayout.CENTER_VERTICAL);
        volumeBrightnessBarParams.setMargins(10, 10, 50, 50);
        mVolumeBar.setId(R.id.pro_volume);
        mViewGroup.addView(mVolumeBar, volumeBrightnessBarParams);
        return this;
    }

    @Override
    public IConstituteView addRightColumnView() {
        mBrightnessBar = new VolumeBrightnessBar(mViewGroup.getContext()).setStyle(1);
        RelativeLayout.LayoutParams volumeBrightnessBarParams = new RelativeLayout.LayoutParams(100, 300);
        volumeBrightnessBarParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        volumeBrightnessBarParams.addRule(RelativeLayout.CENTER_VERTICAL);
        volumeBrightnessBarParams.setMargins(50, 10, 10, 50);
        mBrightnessBar.setId(R.id.pro_brightness);
        mViewGroup.addView(mBrightnessBar, volumeBrightnessBarParams);
        return this;
    }

    @Override
    public IConstituteView addLodingView() {
        return this;
    }

    @Override
    public IConstituteView addBarrageView() {
        return this;
    }

    @Override
    public IConstituteView addAdvertisingView() {
        return this;
    }

    @Override
    public IConstituteView addNavigationView() {
        return this;
    }

    public void showLeft() {
        mBrightnessBar.setVisibility(View.VISIBLE);
        PlayerStatus.PLAYER_CONTROLLER_VIEW_VISIBLE = true;
        mHBWangHandler.removeMessages(0);
        mHBWangHandler.sendEmptyMessageDelayed(0, 5000);
    }

    public void showRight() {
        mVolumeBar.setVisibility(View.VISIBLE);
        PlayerStatus.PLAYER_CONTROLLER_VIEW_VISIBLE = true;
        mHBWangHandler.removeMessages(0);
        mHBWangHandler.sendEmptyMessageDelayed(0, 5000);
    }

    public void showBelow() {
        mHBWangLinearLayout.setVisibility(View.VISIBLE);
        PlayerStatus.PLAYER_CONTROLLER_VIEW_VISIBLE = true;
        mHBWangHandler.removeMessages(0);
        mHBWangHandler.sendEmptyMessageDelayed(0, 5000);
    }
}
