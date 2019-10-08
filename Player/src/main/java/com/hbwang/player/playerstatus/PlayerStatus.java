package com.hbwang.player.playerstatus;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/1/10-17:21
 * 播放器状态（常量）
 */
public class PlayerStatus {
    /**
     * 播放器状态（音频/视频）
     */
    public static int PLAY_STYLE = PlayerValue.PLAY_VIDEO;
    /**
     * 播放器进度条状态（是否拖动同时暂停播放）
     */
    public static boolean PLAYER_PRO_STATUS = true;
    /**
     * 播放器手势
     * 0（null）
     * 1（拖动进度条）
     * 2（拖动亮度）
     * 3（拖动音量）
     */
    public static int PLAYER_GESTURE_STATUS = 0;

    /**
     * 播放状态
     */
    public static int PLAY_STATUS = PlayerValue.PLAY_PAUSE;

    /**
     * 控制层控线是否显示/隐藏
     */
    public static boolean PLAYER_CONTROLLER_VIEW_VISIBLE = true;

    /**
     * 是否全屏
     */
    public static boolean PLAYER_IS_FULL = false;

}
