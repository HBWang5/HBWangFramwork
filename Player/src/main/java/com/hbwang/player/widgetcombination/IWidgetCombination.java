package com.hbwang.player.widgetcombination;

import android.app.Activity;
import android.view.ViewGroup;

import com.hbwang.player.view.mediacontroller.IHBWangMediaController;


/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/19-13:54
 */
public abstract class IWidgetCombination {
    public Activity activity;

    public abstract void bindBackgroundView();

    public abstract void bindPluginView();

    public abstract void bindMideoGroup(ViewGroup viewGroup);

    public abstract void bindSurfaceView();

    public abstract  void playMedia(String url);

    public abstract IHBWangMediaController getControllerView();

    public abstract void initController();

    public void  initMediaPlayer(ViewGroup viewGroup){
        activity = (Activity) viewGroup.getContext();
        bindBackgroundView();
        initController();
        bindMideoGroup(viewGroup);
        bindSurfaceView();
        bindPluginView();
    }
}
