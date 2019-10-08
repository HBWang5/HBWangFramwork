package com.hbwang.player.threadpro;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/22-14:23
 */
public interface IMediaProCallBack {


    /**
     * 初始化配置（每一次播放都需要）
     */
    void setInitProConfig(int duration);
    /**
     * 设置缓冲
     */
    void setBufferPercentage(int percent);

}
