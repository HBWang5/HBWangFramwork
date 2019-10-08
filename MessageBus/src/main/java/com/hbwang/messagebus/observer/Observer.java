package com.hbwang.messagebus.observer;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/2-10:29
 */
public abstract class Observer<T>{
    private int state;

    public abstract void onChange(T t);

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
