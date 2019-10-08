package com.hbwang.api.http.exception;



/**
 * Created by Administrator on 2017/7/12.
 */

public interface IBackState<T> {
    /**
     * 判断返回json类型并反馈数据
     */
    void isJsonListOrObj(String responseBody, Class<T> mClsTo);

    /**
     * 返回类型处理
     */
    void responseCode(int code);

    void responseErroCode(int erroCode, String erroMessage);
}
