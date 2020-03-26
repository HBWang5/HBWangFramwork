package com.hbwang.api.net.callback;


import android.support.annotation.NonNull;

import com.hbwang.api.net.been.NetworkingRespondEntity;
import com.hbwang.api.net.erro.BackState;
import com.hbwang.api.net.erro.filtration.FactoryException;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

import static com.hbwang.api.net.config.ErrorConfig.*;


/**
 * Created by Administrator on 2017/7/12.
 */

public abstract class HBWangCallbackNet<T extends NetworkingRespondEntity> implements Callback<T> {
    private BackState mBackState;

    protected HBWangCallbackNet() {
        if (mBackState == null) {
            mBackState = new BackState(this);
        }
    }


    @Override
    public void onResponse(@NonNull Call<T> call, Response<T> response) {
        //返回code码处理
        mBackState.responseCode(response.code());
    }

    /**
     * 请求失败
     */
    @Override
    public void onFailure(Call<T> call, Throwable e) {
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            switch (httpException.code()) {
                case SUCCEED:
                    break;
                case BAD_REQUEST:
                    onFailure("（错误请求）  服务器不理解请求的语法");
                    break;
                case UNAUTHORIZED:
                    onFailure("（未授权）  请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。");
                    break;
                case FORBID:
                    onFailure("（禁止） 服务器拒绝请求");
                    break;
                case NO_FOUND:
                    onFailure("（未找到）  服务器找不到请求的网页。");
                    break;
                case METHOD_TO_DISABLE:
                    onFailure("（方法禁用） 禁用请求中指定的方法。");
                    break;
                case REJECT:
                    onFailure("（不接受） 无法使用请求的内容特性响应请求的网页。");
                    break;
                case NEED_PROXY:
                    onFailure("（需要代理授权） 此状态代码与 401（未授权）类似，但指定请求者应当授权使用代理。");
                    break;
                case TIME_OUT:
                    onFailure("（请求超时） 服务器等候请求时发生超时。");
                    break;
                case CONFLICT:
                    onFailure("（冲突） 服务器在完成请求时发生冲突。 服务器必须在响应中包含有关冲突的信息。");
                    break;
                case REMOUNT:
                    onFailure("（已删除） 如果请求的资源已永久删除，服务器就会返回此响应。");
                    break;
                case NEED_VALID_LENTH:
                    onFailure("（需要有效长度） 服务器不接受不含有效内容长度标头字段的请求。");
                    break;
                case PREMISE_IS_NOT:
                    onFailure("（未满足前提条件） 服务器未满足请求者在请求中设置的其中一个前提条件。");
                    break;
                case BODY_OUT_SIZE:
                    onFailure("（请求实体过大） 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力。");
                    break;
                case URL_OUT_LONG:
                    onFailure("（请求的 URI 过长） 请求的 URI（通常为网址）过长，服务器无法处理。");
                    break;
                case NO_MEDIA_TYPE:
                    onFailure("（不支持的媒体类型） 请求的格式不受请求页面的支持。");
                    break;
                case SCOUPE_UNQUALIFIED:
                    onFailure("（请求范围不符合要求） 如果页面无法提供请求的范围，则服务器会返回此状态代码。");
                    break;
                case UNMET_EXPECTATION:
                    onFailure("（未满足期望值） 服务器未满足\"期望\"请求标头字段的要求。");
                    break;
                case SERVER_INTERNAL_ERROR:
                    onFailure("（服务器内部错误）  服务器遇到错误，无法完成请求。");
                    break;
                case NO_IMPLEMENT:
                    onFailure("（尚未实施） 服务器不具备完成请求的功能。 例如，服务器无法识别请求方法时可能会返回此代码。");
                    break;
                case BAD_GATEWAY:
                    onFailure("（错误网关） 服务器作为网关或代理，从上游服务器收到无效响应。");
                    break;
                case SERVER_DISABLE:
                    onFailure("（服务不可用）  服务器目前无法使用（由于超载或停机维护）。 通常，这只是暂时状态。");
                    break;
                case GATEWAY_TIME_OUT:
                    onFailure("（网关超时） 服务器作为网关或代理，但是没有及时从上游服务器收到请求。");
                    break;
                case HTTP_VER_ENOTSUP:
                    onFailure("（HTTP 版本不受支持） 服务器不支持请求中所用的 HTTP 协议版本。");
                    break;
                default:
                    onFailure("数据获取失败，请检查网络是否通畅！");
                    break;
            }

        } else if (e instanceof RuntimeException) {
            onFailure("连接超时");
        } else {
            onFailure(FactoryException.analysisException(e));
        }

    }


    public abstract void onSucceed(Object response);

    public abstract void onFailure(String s);

}
