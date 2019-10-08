package com.hbwang.messagebus.lifecycle;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/2-10:41
 */
public interface ILifecycle {

    void onCreate(int activityCode);

    void onDestroy(int activityCode);

    void onPause(int activityCode);

    void onStart(int activityCode);
}
