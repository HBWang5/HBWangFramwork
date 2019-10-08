package com.hbwang.player.view.mediacontroller.impl;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.hbwang.player.R;
import com.hbwang.player.listener.impl.HBWangControllerOnClickListener;
import com.hbwang.player.threadpro.IMediaProCallBack;
import com.hbwang.player.tools.BrightnessTools;
import com.hbwang.player.view.mediacontroller.IHBWangMediaController;
import com.hbwang.player.view.mediacontroller.constitute.impl.ConstituteVideoView;
import com.hbwang.player.view.mediagroup.impl.HBWangMediaGroup;
import com.hbwang.player.view.progress.VolumeBrightnessBar;
import com.hbwang.player.view.surfaceview.IHBWangSurfaceView;
import com.hbwang.player.widget.HBWangImageView;

import static com.hbwang.player.playerstatus.PlayerStatus.PLAYER_IS_FULL;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/12-10:54
 * 播放器控制器
 */
public class HBWangMediaVideoController extends RelativeLayout implements IHBWangMediaController {

    private HBWangMediaGroup mideoGroup;
    private IMediaProCallBack iMediaProCallBack;
    private VolumeBrightnessBar mBrightnessBar;
    private VolumeBrightnessBar mVolumeBar;

    public HBWangMediaVideoController(Context context) {
        super(context);
    }


    public HBWangMediaVideoController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HBWangMediaVideoController(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化配置
     */
    @Override
    public void initViewConfig() {
        BrightnessTools.getInstance().initConfig(getContext());
        //音量控制View
        mBrightnessBar = findViewById(R.id.pro_brightness);
        //亮度控制View
        mVolumeBar = findViewById(R.id.pro_volume);
        //横竖屏控制View
        HBWangImageView hbwangImageFullView = findViewById(R.id.player_full);
        HBWangImageView hbwangImagePauseView = findViewById(R.id.player_pause);
        hbwangImagePauseView.setOnClickListener(new HBWangControllerOnClickListener().bindController(this));
        hbwangImageFullView.setOnClickListener(new HBWangControllerOnClickListener().bindController(this));
        mVolumeBar.setPercent((int) ((float) BrightnessTools.getInstance().getStreamVolume() / (float) BrightnessTools.getInstance().getMaxVolume() * 100));
    }

    /**
     * 初始化控制组合组件
     */
    @Override
    public void initConstituteView(HBWangMediaGroup mideoGroup) {
        this.mideoGroup = mideoGroup;
        ConstituteVideoView.getInstance().init(this)
                .addLeftColumnView()
                .addRightColumnView()
                .addBelowColumnView();
        initViewConfig();

    }

    /**
     * 播放视频
     */
    @Override
    public void playMedia(String url) {
        mideoGroup.getSurfaceView().getMideoPlayer().playMedia(url);
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
        //开始播放
        mideoGroup.getSurfaceView().getMideoPlayer().start();
        //绑定Pro管理器
        mideoGroup.getSurfaceView().getMideoPlayer().bindMediaProManager(iMediaProCallBack);
    }

    @Override
    public void pause() {
        mideoGroup.getSurfaceView().getMideoPlayer().pause();
    }

    @Override
    public void resume() {
        mideoGroup.getSurfaceView().getMideoPlayer().resume();
    }

    @Override
    public void prepare() {
        mideoGroup.getSurfaceView().getMideoPlayer().prepare();
    }

    @Override
    public int getCurrentPosition() {
        try {
            return (int) mideoGroup.getSurfaceView().getMideoPlayer().getCurrentPosition();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public void bindMediaProManager(IMediaProCallBack iMediaProCallBack) {
        this.iMediaProCallBack = iMediaProCallBack;
    }

    @Override
    public void seekTo(int progress) {
        mideoGroup.getSurfaceView().getMideoPlayer().seekTo(progress);
    }

    @Override
    public IHBWangSurfaceView getSurfaceView() {
        return mideoGroup.getSurfaceView();
    }

    @Override
    public void setAppBrightness(int brightness) {
        mBrightnessBar.setPercent(brightness);
        ConstituteVideoView.getInstance().showLeft();
    }

    @Override
    public void setVolumeGesture(int volume) {
        mVolumeBar.setPercent(volume);
        ConstituteVideoView.getInstance().showRight();
    }

    @Override
    public void showUI() {
        ConstituteVideoView.getInstance().setVisibiLity();
    }

    @Override
    public void playerFull(Activity context) {
        if (PLAYER_IS_FULL) {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //切换为竖屏
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            PLAYER_IS_FULL = false;
            pullMeasureLayout();
        }
        //切换为横屏
        else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            PLAYER_IS_FULL = true;
            pullMeasureLayout();
        }
    }

    @Override
    public void pullMeasureLayout() {
        ViewGroup.LayoutParams layoutParams = mideoGroup.getLayoutParams();
        if (PLAYER_IS_FULL) {
            ((Activity) mideoGroup.getContext()).getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //隐藏状态栏
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        } else {
            ((Activity) mideoGroup.getContext()).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //显示状态栏
            layoutParams.height = 600;
        }
        mideoGroup.setLayoutParams(layoutParams);
    }


}