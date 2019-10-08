package com.hbwang.messagebus.livedata.impl;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.hbwang.messagebus.config.LifecycleStale;
import com.hbwang.messagebus.fragment.LiveDataFrag;
import com.hbwang.messagebus.lifecycle.impl.Lifecycle;
import com.hbwang.messagebus.livedata.ILiveData;
import com.hbwang.messagebus.observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/2-10:31
 */
public class LiveData<T> implements ILiveData{
    //消息通道  Integer（Activity地址）
    @SuppressLint("UseSparseArrays")
    private Map<Integer , Observer<T>> mMessageAlpha = new HashMap<>();

    //缓冲消息通道  Integer（Activity地址）
    @SuppressLint("UseSparseArrays")
    private Map<Integer , List<T>> mBufferMessageAlpha = new HashMap<>();

    //消息移除列表
    private ArrayList<Integer> mRemoveList = new ArrayList<>();

    //主线程引用
    private Handler handler = new Handler(Looper.getMainLooper());

    public LiveData() {
    }

    /**
     * 发送消息
     * @param message 消息体
     */
    public void postMessage(final T message){
        synchronized (this){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    setMessage(message);
                }
            });
        }
    }

    private void setMessage(T message){
        //便利Map集合
        for (Map.Entry<Integer, Observer<T>> entry : mMessageAlpha.entrySet()) {
            Observer<T> observer = entry.getValue();
            Integer activityCode = entry.getKey();
            //活动状态
            if (observer.getState() == LifecycleStale.ACTIVE_STALE) {
                observer.onChange(message);
            }
            //失去焦点状态
            if (observer.getState() == LifecycleStale.ONPAUSE_STALE) {
                if (mBufferMessageAlpha.get(activityCode) == null) {
                    mBufferMessageAlpha.put(activityCode,new ArrayList<T>());
                }
                if (!mBufferMessageAlpha.get(activityCode).contains(message)) {
                    mBufferMessageAlpha.get(activityCode).add(message);
                }

            }
            //销毁状态
            if (observer.getState() == LifecycleStale.DESTORY_STALE) {
                mRemoveList.add(activityCode);
            }
        }
        //移除销毁对列
        for (Integer integer : mRemoveList){
            mMessageAlpha.remove(integer);
        }

    }

    /**
     * @param obj   生命周期管理(View)上下文对象
     * @param observer  订阅者
     */
    public void observe(T obj , Observer<T> observer) {
        FragmentManager fragmentManager = null;
        //判断绑定view场景
        if (obj instanceof Fragment) {
            fragmentManager = ((Fragment)obj).getFragmentManager();
        }
        if (obj instanceof FragmentActivity) {
            fragmentManager = ((FragmentActivity)obj).getSupportFragmentManager();
        }
        //动态添加fragment并控制生命周期
        assert fragmentManager != null;
        LiveDataFrag mLiveDataFrag = (LiveDataFrag) fragmentManager.findFragmentByTag(LifecycleStale.FRAGMENT_TAG);
        if (mLiveDataFrag == null) {
            mLiveDataFrag = new LiveDataFrag();
            fragmentManager.beginTransaction().add(mLiveDataFrag,LifecycleStale.FRAGMENT_TAG).commitAllowingStateLoss();
        }
        mLiveDataFrag.setILifecycle(new Lifecycle(mMessageAlpha,mBufferMessageAlpha));

        //注册
        mMessageAlpha.put(obj.hashCode() , observer);
    }
}
