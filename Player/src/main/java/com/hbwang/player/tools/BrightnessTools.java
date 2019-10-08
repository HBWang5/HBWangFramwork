package com.hbwang.player.tools;

import android.app.Activity;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;



/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/2/25-17:32
 */
public class BrightnessTools {
    private ContentResolver resolver;
    private int maxBrightness = 255;
    private AudioManager mAudioManager;
    private static BrightnessTools mBrightnessTools;
    private BrightnessTools() {

    }

    public BrightnessTools initConfig(Context context){
        resolver = context.getContentResolver();
        mAudioManager = (AudioManager) context.getSystemService(Service.AUDIO_SERVICE);//初始化获取音量属性
        return this;
    }
    public static BrightnessTools getInstance(){
        if (mBrightnessTools == null) {
            mBrightnessTools = new BrightnessTools();
        }
        return mBrightnessTools;
    }

    /*
     * 调整亮度范围
     */
    private int adjustBrightnessNumber(int brightness) {
        if (brightness < 0) {
            brightness = 0;
        } else if (brightness > 255) {
            brightness = 255;
        }
        return brightness;
    }

    /*
     * 关闭自动调节亮度
     */
    public void offAutoBrightness() {
        try {
            if (Settings.System.getInt(resolver, Settings.System.SCREEN_BRIGHTNESS_MODE) == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC) {
                Settings.System.putInt(resolver,
                        Settings.System.SCREEN_BRIGHTNESS_MODE,
                        Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * 获取系统亮度
     */
    public int getBrightness(Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        return (int) layoutParams.screenBrightness;
//        return Settings.System.getInt(resolver, Settings.System.SCREEN_BRIGHTNESS, 255);
    }

    /*
     * 设置系统亮度，如果有设置了自动调节，请先调用offAutoBrightness()方法关闭自动调节，否则会设置失败
     */
    public void setSystemBrightness(int newBrightness) {
        Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS
                , newBrightness);
    }

    public int getMaxBrightness() {
        return maxBrightness;
    }

    //设置当前APP的亮度
    public void setOftenBrightness( Activity activity) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }


    //设置当前APP的亮度
    public void setAppBrightness(float brightnessPercent, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.screenBrightness = brightnessPercent * (1f / 255f);
        window.setAttributes(layoutParams);
    }

    public void setVolumeGesture(int newVolume) {
        if (newVolume + getStreamVolume() > getMaxVolume()) {
            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, getMaxVolume(),AudioManager.FLAG_PLAY_SOUND);
        }
        if (newVolume + getStreamVolume() < 0) {
            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0,AudioManager.FLAG_PLAY_SOUND);
        }
        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, newVolume + getStreamVolume(),AudioManager.FLAG_PLAY_SOUND);
    }

    public int getMaxVolume(){
        return mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    }

    public int getStreamVolume(){
        return mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }
}
