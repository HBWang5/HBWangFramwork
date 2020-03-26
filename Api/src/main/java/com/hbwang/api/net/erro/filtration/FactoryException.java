package com.hbwang.api.net.erro.filtration;

import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.concurrent.TimeoutException;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2020/3/26-12:47
 */
public class FactoryException {
    private static final String CONNECT_EXCEPTION_MSG = "网络无连接，请检查网络后重试";
    private static final String JSON_EXCEPTION_MSG = "数据解析失败";
    private static final String UNKNOWN_EXCEPTION_MSG = "请求失败，请稍后重试";
    private static final String TIME_OUT_MSG = "请求超时，请稍后重试";

    private FactoryException() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 解析异常
     */
    public static String analysisException(Throwable e) {
        if (e instanceof ConnectException) {
            /*链接异常*/
            return UNKNOWN_EXCEPTION_MSG;
        } else if (e instanceof SocketTimeoutException || e instanceof TimeoutException) {
            /*请求超时异常*/
            return TIME_OUT_MSG;
        } else if (e instanceof JsonParseException || e instanceof JSONException
                || e instanceof ParseException || e instanceof MalformedJsonException) {
            return JSON_EXCEPTION_MSG;
        } else if (e instanceof UnknownHostException) {
            /*无法解析该域名异常*/
            return CONNECT_EXCEPTION_MSG;
        } else {
            /*未知异常*/
            return UNKNOWN_EXCEPTION_MSG;
        }
    }
}
