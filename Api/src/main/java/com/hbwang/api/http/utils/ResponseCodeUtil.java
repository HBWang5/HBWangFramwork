package com.hbwang.api.http.utils;


import com.hbwang.api.http.callback.HBWangCallbackNet;
import com.hbwang.api.http.error.config.ErrorConfig;
import com.hbwang.api.http.error.filtration.ErrorDataFiltration;

/**
 * Created by Administrator on 2017/7/12.
 * 服务器反馈code处理
 */

public class ResponseCodeUtil {
    private static ResponseCodeUtil mResponseCodeUtil;

    private ResponseCodeUtil() {
    }

    public static synchronized ResponseCodeUtil getResponseCodeUtil() {
        if (mResponseCodeUtil == null) {
            mResponseCodeUtil = new ResponseCodeUtil();
        }
        return mResponseCodeUtil;
    }

    public void codeManage(int code, HBWangCallbackNet mHBWangCallbackNet) {
        switch (code) {
            case  ErrorConfig.SUCCEED:
                mHBWangCallbackNet.response();
                break;
            default:
                //错误信息过滤反馈信息
                ErrorDataFiltration.getInstance().produce(mHBWangCallbackNet, code);
                break;
        }
    }

}
