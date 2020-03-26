package com.hbwang.api.net.erro.filtration;


import com.hbwang.api.net.callback.HBWangCallbackNet;
import com.hbwang.api.net.config.ErrorConfig;


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
        if (code == ErrorConfig.SUCCEED) {
        } else {//错误信息过滤反馈信息
            ErrorDataFiltration.getInstance().produce(mHBWangCallbackNet, code);
        }
    }

}
