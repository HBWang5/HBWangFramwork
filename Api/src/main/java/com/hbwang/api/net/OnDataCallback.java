package com.hbwang.api.net;


/**
 * Created by JIAPI on 2015/10/14.
 */
public interface OnDataCallback<T> {

    public void onSuccess(Object pResponse);

    public void onError(String pError);

}
