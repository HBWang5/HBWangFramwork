package com.hbwang.api.net.erro;



import com.hbwang.api.net.callback.HBWangCallbackNet;
import com.hbwang.api.net.erro.filtration.ResponseCodeUtil;

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
    public void responseErrorCode(int errorCode, String errorMessage) {
        if (errorCode != 0) {
            mHBWangCallbackNet.onFailure(errorMessage);
        }
    }
}
