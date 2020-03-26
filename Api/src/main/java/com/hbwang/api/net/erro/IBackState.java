package com.hbwang.api.net.erro;



/**
 * Created by Administrator on 2017/7/12.
 */

public interface IBackState<T> {

    /**
     * 返回类型处理
     */
    void responseCode(int code);

    void responseErrorCode(int erroCode, String erroMessage);
}
