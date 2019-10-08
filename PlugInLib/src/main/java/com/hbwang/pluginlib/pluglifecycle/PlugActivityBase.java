package com.hbwang.pluginlib.pluglifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hbwang.pluginlib.config.PlugInConfig;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/26-10:23
 */
public abstract class PlugActivityBase extends Activity implements IPlugActivity{
    private int mFrom = PlugInConfig.FROM_EXTERNAL;
    private Activity activity;
    @Override
    public void attach(Activity activity) {
        this.activity = activity;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mFrom = savedInstanceState.getInt(PlugInConfig.FROM_KEY);
        }
        if (mFrom == PlugInConfig.FROM_INTERNAL){
            super.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (mFrom == PlugInConfig.FROM_INTERNAL){
            super.onNewIntent(intent);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        if (mFrom == PlugInConfig.FROM_INTERNAL){
            super.setContentView(layoutResID);
        }else {
            activity.setContentView(layoutResID);
        }
    }

    @Override
    public void onStart() {
        if (mFrom == PlugInConfig.FROM_INTERNAL){
            super.onStart();
        }
    }

    @Override
    public void onResume() {
        if (mFrom == PlugInConfig.FROM_INTERNAL){
            super.onResume();
        }
    }

    @Override
    public void onRestart() {
        if (mFrom == PlugInConfig.FROM_INTERNAL){
            super.onRestart();
        }
    }

    @Override
    public void onPause() {
        if (mFrom == PlugInConfig.FROM_INTERNAL){
            super.onPause();
        }
    }

    @Override
    public void onStop() {
        if (mFrom == PlugInConfig.FROM_INTERNAL){
            super.onStop();
        }
    }

    @Override
    public void onDestroy() {
        if (mFrom == PlugInConfig.FROM_INTERNAL){
            super.onDestroy();
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if (mFrom == PlugInConfig.FROM_INTERNAL){
            super.startActivityForResult(intent,requestCode);
        }
    }
}
