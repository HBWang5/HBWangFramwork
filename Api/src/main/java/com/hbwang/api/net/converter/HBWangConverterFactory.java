package com.hbwang.api.net.converter;


import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.hbwang.api.net.been.NetworkingRespondEntity;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/7/1-16:42
 */
public class HBWangConverterFactory extends Converter.Factory{
    private final Gson gson;

    public static HBWangConverterFactory create() {
        return create(new Gson());
    }

    public static HBWangConverterFactory create(Gson gson) {
        return new HBWangConverterFactory(gson);
    }

    private HBWangConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        //判断响应实体类型是否是我们需要特殊处理的特殊类型(此处以String类型)
        if (type == NetworkingRespondEntity.class) {
            //创建xxConverter来 进行特殊转换
            return new ResponseConverter<NetworkingRespondEntity>(gson);
        } else {
            //其它类型我们不处理
            return null;
        }
    }

    private class ResponseConverter<T> implements Converter<ResponseBody, T> {
        private final Gson gson;

        ResponseConverter(Gson gson) {
            this.gson = gson;
        }

        @Override
        public T convert(ResponseBody value) throws IOException {
            //在此处进行我们的转换
            String response = value.string();
            NetworkingRespondEntity movieDataBean = gson.fromJson(response, NetworkingRespondEntity.class);
            return (T) movieDataBean;
            //TODO:嵌套解析
//            if (resultResponse.getResult() == 0){
//                //result==0表示成功返回，继续用本来的Model类解析
//                return gson.fromJson(response, type);
//            } else {
//                //ErrResponse 将msg解析为异常消息文本
//                ErrResponse errResponse = gson.fromJson(response, ErrResponse.class);
//                throw new ResultException(resultResponse.getResult(), errResponse.getMsg());
//            }

        }

    }
}
