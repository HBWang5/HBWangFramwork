package com.hbwang.player.widgetcombination.impl;

import android.view.ViewGroup;

import com.hbwang.player.view.mediacontroller.IHBWangMediaController;
import com.hbwang.player.view.mediacontroller.impl.HBWangMediaMusicController;
import com.hbwang.player.widgetcombination.IWidgetCombination;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/19-13:52
 */
public class WidgetMusicCombination extends IWidgetCombination {

    private HBWangMediaMusicController mHBWangMediaVideoController;

    public WidgetMusicCombination() {

    }

    @Override
    public void bindBackgroundView() {

    }

    @Override
    public void bindPluginView() {

    }

    @Override
    public void bindMideoGroup(ViewGroup viewGroup) {
        viewGroup.addView(mHBWangMediaVideoController);
    }

    @Override
    public void bindSurfaceView() {

    }

    @Override
    public void playMedia(String url) {
        mHBWangMediaVideoController.playMedia(url);
    }

    @Override
    public IHBWangMediaController getControllerView() {
        return mHBWangMediaVideoController;
    }

    @Override
    public void initController() {
        mHBWangMediaVideoController = new HBWangMediaMusicController(activity);
    }
}
