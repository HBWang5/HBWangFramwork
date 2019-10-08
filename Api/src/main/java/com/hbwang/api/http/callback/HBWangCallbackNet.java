package com.hbwang.api.http.callback;


import com.squareup.okhttp.ResponseBody;
import com.hbwang.api.http.exception.impl.BackState;

import java.io.IOException;

import retrofit.Callback;
import retrofit.Response;

/**
 * Created by Administrator on 2017/7/12.
 */

public abstract class HBWangCallbackNet<T extends ResponseBody> implements Callback<T> {
    private BackState mBackState;
    private Class<T> mClsTo;
    private String string = null;

    public HBWangCallbackNet(Class<T> mClsTo) {
        this.mClsTo = mClsTo;
        if (mBackState == null) {
            mBackState = new BackState(this);
        }
    }



    /**
     * 请求成功
     */
    @Override
    public void onResponse(Response<T> response) {
        try {
            if (response.body() != null) {
                string = response.body().string();
            }
            //返回code码处理
            mBackState.responseCode(response.code());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 请求失败
     */
    @Override
    public void onFailure(Throwable t) {
        onFailure("数据获取失败，请检查网络是否通畅！");
    }

    /**
     * 处理服务器反馈数据
     */
    public void response() {
        if (string != null) {
            mBackState.isJsonListOrObj(string, mClsTo);
        }
    }

    public abstract void onSucceed(Object response);

    public abstract void onFailure(String message);

}
