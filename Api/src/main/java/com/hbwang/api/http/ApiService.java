package com.hbwang.api.http;


import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.http.GET;

public interface ApiService<T> {
    //得到城市列表接口
    @GET("")
    Call<ResponseBody> getCities();
}