package com.hbwang.api.net.erro;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2020/3/20-15:31
 */
public class ResultException extends RuntimeException {

    private int errCode = 0;

    public ResultException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }
}