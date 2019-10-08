package com.hbwang.api.config;




/**
 * 公共参数的配置.
 *
 * @author Jacob.Wu
 */
public class Config {
    /**
     * 是否联网
     */
    public static boolean IS_INTERNET_CONNECTED;

    /**
     * 网络状态
     */
    public static final int SINGLE_THREAD_EXECUTOR = 0;
    public static final int SCHEDULED_THREAD_EXECUTOR = 1;
    public static final int SFIXED_THREAD_EXECUTOR = 2;
    public static final int CACHED_THREAD_EXECUTOR = 3;
}
