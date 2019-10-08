package com.hbwang.messagebus.config;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/2-10:55
 */
public class LifecycleStale {
    /**
     * 初始化状态
     */
    public static final int INIT_STALE = 0;
    /**
     * 活动状态
     */
    public static final int ACTIVE_STALE = 1;
    /**
     * 失去焦点状态
     */
    public static final int ONPAUSE_STALE = 2;
    /**
     * 销毁状态
     */
    public static final int DESTORY_STALE = 3;

    public static final String FRAGMENT_TAG = "com.hbwang.messagebus";
}
