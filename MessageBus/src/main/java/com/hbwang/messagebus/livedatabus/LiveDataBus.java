package com.hbwang.messagebus.livedatabus;


import com.hbwang.messagebus.livedata.impl.LiveData;

import java.util.HashMap;
import java.util.Map;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/2-10:16
 */
public class LiveDataBus {
    //LiveData消息通道 集合
    private Map<String, LiveData<Object>> mMutableLiveDataMap;
    private static LiveDataBus mLiveDataBus;

    private LiveDataBus() {
        mMutableLiveDataMap = new HashMap<>();
    }

    public static synchronized LiveDataBus getInstance() {
        if (mLiveDataBus == null) {
            mLiveDataBus = new LiveDataBus();
        }
        return mLiveDataBus;
    }

    /**
     * 获取消息通道
     */
    public <T> LiveData<T> getChannel(String target , Class<T> type){
        if (!mMutableLiveDataMap.containsKey(target)) {
            mMutableLiveDataMap.put(target,new LiveData<>());
        }
        return (LiveData<T>) mMutableLiveDataMap.get(target);
    }

    public <T> LiveData<T> getChannel(String target){
        return getChannel(target,null);
    }
}
