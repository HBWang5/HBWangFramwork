package com.hbwang.player.view.mediacontroller.constitute.impl;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

import com.hbwang.player.threadpro.impl.HBWangThreadMediaPro;
import com.hbwang.player.view.mediacontroller.IHBWangMediaController;
import com.hbwang.player.view.mediacontroller.constitute.IConstituteView;
import com.hbwang.player.view.progress.HBWangSeekBar;
import com.hbwang.player.widget.HBWangImageView;
import com.hbwang.player.widget.HBWangTextView;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/19-16:31
 */
public class ConstituteMusicView implements IConstituteView {

    @SuppressLint("StaticFieldLeak")
    private static ConstituteMusicView mConstituteMusicView;
    private ViewGroup viewGroup;


    public static synchronized ConstituteMusicView getInstance() {
        if (mConstituteMusicView == null) {
            mConstituteMusicView = new ConstituteMusicView();
        }
        return mConstituteMusicView;
    }

    @Override
    public IConstituteView addBelowColumnView() {
        HBWangSeekBar mHBWangSeekBar = new HBWangSeekBar(viewGroup.getContext());
        viewGroup.addView(mHBWangSeekBar);
        HBWangTextView mHBWangTextView = new HBWangTextView(viewGroup.getContext());
        viewGroup.addView(mHBWangTextView);

        HBWangThreadMediaPro mHBWangThreadMediaPro = new HBWangThreadMediaPro();
        mHBWangThreadMediaPro.bind(mHBWangSeekBar, mHBWangTextView, (IHBWangMediaController) viewGroup);
        ((IHBWangMediaController) viewGroup).bindMediaProManager(mHBWangThreadMediaPro);
        mHBWangThreadMediaPro.start();

        return this;
    }

    @Override
    public IConstituteView addTopColumnView() {
        HBWangTextView mHBWangTextView = new HBWangTextView(viewGroup.getContext());
        viewGroup.addView(mHBWangTextView);
        return this;
    }

    @Override
    public IConstituteView addLeftColumnView() {
        HBWangImageView mHBWangImageView = new HBWangImageView(viewGroup.getContext());
        viewGroup.addView(mHBWangImageView);
        return this;
    }

    @Override
    public IConstituteView addRightColumnView() {
        HBWangImageView mHBWangImageView = new HBWangImageView(viewGroup.getContext());
        viewGroup.addView(mHBWangImageView);
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

    @Override
    public IConstituteView init(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
        return this;
    }

}
