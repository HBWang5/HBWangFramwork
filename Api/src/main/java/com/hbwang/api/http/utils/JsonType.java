package com.hbwang.api.http.utils;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbwang.api.http.callback.HBWangCallbackNet;
import com.hbwang.api.http.exception.impl.BackState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */

public class JsonType<T> {
    private static JsonType mJsonType;
    private static Gson gson;
    private static ArrayList arrayObj;

    private JsonType() {
        arrayObj = new ArrayList();
        gson = new Gson();
    }

    public static synchronized JsonType getJsonType() {
        if (mJsonType == null) {
            mJsonType = new JsonType();
        }
        return mJsonType;
    }


    public void parseCommonJson(String responseBody, HBWangCallbackNet mHBWangCallbackNet, Class<T> mClsTo, BackState backState) {
        if (isJsonEmpty(responseBody)) {
            mHBWangCallbackNet.onFailure("数据异常");
        }
        Object obj;
        if (responseBody.substring(0,5).contains("[")) {
            obj = gson.fromJson(responseBody, new TypeToken<List>(){}.getType());
        }else {
            obj =  gson.fromJson(responseBody, mClsTo);
        }


//        if (modelBase.getStatus().equals("SUCCEED")) {
        mHBWangCallbackNet.onSucceed(obj);
//        } else {
//            mHBWangCallbackNet.onFailure(modelBase.getErrorMessage());
//        }


    }


    public static boolean isJsonEmpty(String data) {
        if (data == null || "".equals(data) || "[]".equals(data)
                || "{}".equals(data) || "null".equals(data)) {
            return true;
        }
        return false;
    }
}
