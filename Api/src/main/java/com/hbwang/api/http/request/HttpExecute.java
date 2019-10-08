package com.hbwang.api.http.request;


import com.squareup.okhttp.ResponseBody;
import com.hbwang.api.http.OnDataCallback;
import com.hbwang.api.http.callback.HBWangCallbackNet;

import retrofit.Call;

/**
 * Created by Administrator on 2017/7/10.
 * 网络请求
 */

public class HttpExecute {
    private static HttpExecute mHttpExecute;

    private HttpExecute() {

    }

    public static synchronized HttpExecute getHttpExecute() {
        if (mHttpExecute == null) {
            mHttpExecute = new HttpExecute();
        }
        return mHttpExecute;
    }

    /**
     * 执行请求
     */
    public<T> void executeCall(Call<ResponseBody> call, final OnDataCallback<T> callback, Class<T> mClsTo) {
        call.enqueue(new HBWangCallbackNet<ResponseBody>((Class<ResponseBody>) mClsTo) {

            @Override
            public void onSucceed(Object response) {
                callback.onSuccess(response);
            }

            @Override
            public void onFailure(String message) {
                callback.onError(message);
            }
        });
    }
}
