package com.hbwang.api.net.config;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/8/12-15:24
 */
public class ErrorConfig {
    /**
     * 服务器成功返回网页
     */
    public final static int SUCCEED = 200;
    /**
     * （错误请求）  服务器不理解请求的语法
     */
    public final static int BAD_REQUEST= 400;
    /**
     * （未授权）  请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。
     */
    public final static int UNAUTHORIZED = 401;

    /**
     * （禁止） 服务器拒绝请求
     */
    public final static int FORBID = 403;
    /**
     * （未找到）  服务器找不到请求的网页。
     */
    public final static int NO_FOUND = 404;
    /**
     * （方法禁用） 禁用请求中指定的方法。
     */
    public final static int METHOD_TO_DISABLE = 405;
    /**
     * （不接受） 无法使用请求的内容特性响应请求的网页。
     */
    public final static int REJECT = 406;
    /**
     * （需要代理授权） 此状态代码与 401（未授权）类似，但指定请求者应当授权使用代理。
     */
    public final static int NEED_PROXY = 407;
    /**
     * （请求超时） 服务器等候请求时发生超时。
     */
    public final static int TIME_OUT = 408;
    /**
     * （冲突） 服务器在完成请求时发生冲突。 服务器必须在响应中包含有关冲突的信息。
     */
    public final static int CONFLICT = 409;
    /**
     * （已删除） 如果请求的资源已永久删除，服务器就会返回此响应。
     */
    public final static int REMOUNT = 410;
    /**
     * （需要有效长度） 服务器不接受不含有效内容长度标头字段的请求。
     */
    public final static int NEED_VALID_LENTH = 411;
    /**
     * （未满足前提条件） 服务器未满足请求者在请求中设置的其中一个前提条件。
     */
    public final static int PREMISE_IS_NOT  = 412;
    /**
     * （请求实体过大） 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力。
     */
    public final static int BODY_OUT_SIZE = 413;
    /**
     * （请求的 URI 过长） 请求的 URI（通常为网址）过长，服务器无法处理。
     */
    public final static int URL_OUT_LONG = 414;
    /**
     * （不支持的媒体类型） 请求的格式不受请求页面的支持。
     */
    public final static int NO_MEDIA_TYPE = 415;
    /**
     * （请求范围不符合要求） 如果页面无法提供请求的范围，则服务器会返回此状态代码。
     */
    public final static int SCOUPE_UNQUALIFIED = 416;
    /**
     * （未满足期望值） 服务器未满足"期望"请求标头字段的要求。
     */
    public final static int UNMET_EXPECTATION = 417;


    /**
     * （服务器内部错误）  服务器遇到错误，无法完成请求。
     */
    public final static int SERVER_INTERNAL_ERROR = 500;
    /**
     * （尚未实施） 服务器不具备完成请求的功能。 例如，服务器无法识别请求方法时可能会返回此代码。
     */
    public final static int NO_IMPLEMENT = 501;
    /**
     * （错误网关） 服务器作为网关或代理，从上游服务器收到无效响应。
     */
    public final static int BAD_GATEWAY = 502;
    /**
     * （服务不可用）  服务器目前无法使用（由于超载或停机维护）。 通常，这只是暂时状态。
     */
    public final static int SERVER_DISABLE = 503;
    /**
     * （网关超时） 服务器作为网关或代理，但是没有及时从上游服务器收到请求。
     */
    public final static int GATEWAY_TIME_OUT = 504;

    /**
     * （HTTP 版本不受支持） 服务器不支持请求中所用的 HTTP 协议版本。
     */
    public final static int HTTP_VER_ENOTSUP = 505;

}
