package com.hbwang.api.http.error.filtration;

import com.hbwang.api.http.callback.HBWangCallbackNet;
import com.hbwang.api.http.error.config.ErrorConfig;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/8/12-15:25
 */
public class ErrorDataFiltration {

    private static ErrorDataFiltration mErrorDataFiltration;

    private ErrorDataFiltration() {
    }

    public static ErrorDataFiltration getInstance() {
        if (mErrorDataFiltration == null) {
            mErrorDataFiltration = new ErrorDataFiltration();
        }
        return mErrorDataFiltration;
    }

    public void produce(HBWangCallbackNet mHBWangCallbackNet, int type) {

        switch (type) {
            case ErrorConfig.SUCCEED:

                break;
            default:
                mHBWangCallbackNet.onFailure("请检查网络");
        }
    }
}
