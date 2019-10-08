package com.hbwang.player.servce.impl;


import com.hbwang.player.servce.HBWangBaseService;
import com.hbwang.player.view.mediaplayer.IHBWangMediaPlayer;
import com.hbwang.player.view.mediaplayer.proxy.HBWangMediaPlayerProxy;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/1/10-17:28
 */
public class MideoPlayerServce extends HBWangBaseService {

    private HBWangMediaPlayerProxy mHBWangMediaPlayerProxy;

    @Override
    protected void initMideoPlayer() {
        mHBWangMediaPlayerProxy = new HBWangMediaPlayerProxy();
        mHBWangMediaPlayerProxy.prepare();
    }

    @Override
    public IHBWangMediaPlayer getMideoPlayer() {
        return mHBWangMediaPlayerProxy;
    }

}
