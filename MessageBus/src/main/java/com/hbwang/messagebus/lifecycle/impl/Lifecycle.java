package com.hbwang.messagebus.lifecycle.impl;

import com.hbwang.messagebus.config.LifecycleStale;
import com.hbwang.messagebus.lifecycle.ILifecycle;
import com.hbwang.messagebus.observer.Observer;

import java.util.List;
import java.util.Map; /**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/2-10:54
 */
public class Lifecycle<T> implements ILifecycle {
    //消息队列
    private Map<Integer, Observer> mMessageAlpha;
    //缓冲消息队列
    private Map<Integer, List<T>> mBufferMessageAlpha;
    public Lifecycle(Map<Integer, Observer> mMessageAlpha, Map<Integer, List<T>> mBufferMessageAlpha) {
        this.mMessageAlpha = mMessageAlpha;
        this.mBufferMessageAlpha = mBufferMessageAlpha;
    }

    @Override
    public void onCreate(int activityCode) {
        //添加状态
        mMessageAlpha.get(activityCode).setState(LifecycleStale.INIT_STALE);
    }

    @Override
    public void onDestroy(int activityCode) {

        mMessageAlpha.remove(activityCode);
        //添加状态
        mMessageAlpha.get(activityCode).setState(LifecycleStale.DESTORY_STALE);
    }

    @Override
    public void onPause(int activityCode) {
        mMessageAlpha.get(activityCode).setState(LifecycleStale.ONPAUSE_STALE);
    }

    @Override
    public void onStart(int activityCode) {
        mMessageAlpha.get(activityCode).setState(LifecycleStale.ACTIVE_STALE);
        if (mBufferMessageAlpha.get(activityCode) == null || mBufferMessageAlpha.get(activityCode).size() == 0) {
            return;
        }
        for (T t:mBufferMessageAlpha.get(activityCode)){
            mMessageAlpha.get(activityCode).onChange(t);
        }
        mBufferMessageAlpha.get(activityCode).clear();
    }

}
