package com.hbwang.player.view.mediacontroller.impl;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout;

import com.hbwang.player.servce.impl.MideoPlayerServce;
import com.hbwang.player.threadpro.IMediaProCallBack;
import com.hbwang.player.view.mediacontroller.IHBWangMediaController;
import com.hbwang.player.view.mediacontroller.constitute.impl.ConstituteMusicView;
import com.hbwang.player.view.mediagroup.impl.HBWangMediaGroup;
import com.hbwang.player.view.surfaceview.IHBWangSurfaceView;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/19-13:45
 */
public class HBWangMediaMusicController extends RelativeLayout implements IHBWangMediaController {
    private IMediaProCallBack iMediaProCallBack;

    public HBWangMediaMusicController(Context context) {
        super(context);
    }

    public HBWangMediaMusicController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HBWangMediaMusicController(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void playMedia(String url) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void start() {
        MideoPlayerServce.getMideoPlayerServic().getMideoPlayer().bindMediaProManager(iMediaProCallBack);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void prepare() {

    }

    @Override
    public int getCurrentPosition() {
        return 0;
    }

    @Override
    public void bindMediaProManager(IMediaProCallBack iMediaProCallBack) {
        this.iMediaProCallBack = iMediaProCallBack;
    }

    @Override
    public void seekTo(int progress) {

    }

    @Override
    public IHBWangSurfaceView getSurfaceView() {
        return null;
    }

    @Override
    public void setAppBrightness(int brightness) {

    }

    @Override
    public void setVolumeGesture(int volume) {

    }

    @Override
    public void showUI() {

    }

    @Override
    public void playerFull(Activity context) {

    }

    @Override
    public void pullMeasureLayout() {

    }

    @Override
    public void initViewConfig() {

    }

    @Override
    public void initConstituteView(HBWangMediaGroup mideoGroup) {
        ConstituteMusicView.getInstance().init(this)
                .addLeftColumnView()
                .addLeftColumnView()
                .addRightColumnView()
                .addBelowColumnView();
    }
}
