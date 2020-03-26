package com.hbwang.api.net.erro.filtration;

import com.hbwang.api.net.callback.HBWangCallbackNet;
import com.hbwang.api.net.config.ErrorConfig;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/8/12-15:25
 */
class ErrorDataFiltration {

    private static ErrorDataFiltration mErrorDataFiltration;

    private ErrorDataFiltration() {
    }

    static ErrorDataFiltration getInstance() {
        if (mErrorDataFiltration == null) {
            mErrorDataFiltration = new ErrorDataFiltration();
        }
        return mErrorDataFiltration;
    }

    void produce(HBWangCallbackNet mHBWangCallbackNet, int type) {

        if (type == ErrorConfig.SUCCEED) {
        } else {
            mHBWangCallbackNet.onFailure("请检查网络");
        }
    }
}
