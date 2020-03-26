package com.hbwang.api.net;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService<T> {
    //得到城市列表接口
    @GET("")
    Call<ResponseBody> getCities();
}