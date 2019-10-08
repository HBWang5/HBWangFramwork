package com.hbwang.pluginlib.pluglifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/20-16:24
 */
public interface IPlugActivity {
    void setContentView(int layoutResID);

    void attach(Activity activity);

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onRestart();

    void onPause();

    void onStop();

    void onDestroy();

    void startActivityForResult(Intent intent, int requestCode);

    void onNewIntent(Intent intent);
}
