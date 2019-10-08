package com.hbwang.api.http.exception.impl;



import com.hbwang.api.http.callback.HBWangCallbackNet;
import com.hbwang.api.http.exception.IBackState;
import com.hbwang.api.http.utils.JsonType;
import com.hbwang.api.http.utils.ResponseCodeUtil;


/**
 * Created by Administrator on 2017/7/12.
 * 返回类型处理业务类
 */

public class BackState<T> implements IBackState<T> {
    private HBWangCallbackNet mHBWangCallbackNet;

    public BackState(HBWangCallbackNet mHBWangCallbackNet) {
        this.mHBWangCallbackNet = mHBWangCallbackNet;
    }

    /**
     * 判断返回json类型并反馈数据
     */
    @Override
    public  void isJsonListOrObj(String responseBody, Class<T> mClsTo) {
        JsonType.getJsonType().parseCommonJson(responseBody, mHBWangCallbackNet, mClsTo, this);
    }

    /**
     * 返回类型处理
     */
    @Override
    public void responseCode(int code) {
        ResponseCodeUtil.getResponseCodeUtil().codeManage(code, mHBWangCallbackNet);
    }

    /**
     * 返回类型处理
     */
    @Override
    public void responseErroCode(int erroCode, String erroMessage) {
        if (erroCode != 0) {
            mHBWangCallbackNet.onFailure(erroMessage);
        }
    }
}
