package com.hbwang.api.http;


/**
 * Created by JIAPI on 2015/10/14.
 */
public interface OnDataCallback<T> {

    public void onSuccess(Object pResponse);

    public void onError(String pError);

}
