package com.hbwang.api.base.app;

import android.app.Application;
import android.content.Context;

import com.hbwang.api.config.Config;
import com.hbwang.api.http.sslcontext.HBWangSSLContext;
import com.squareup.okhttp.OkHttpClient;
import com.hbwang.api.ThreadPoolExecutor.Factory.ThreadPoolExecutorFactoryImpl.ThreadPoolExecutorFactoryImpl;
import com.hbwang.api.ThreadPoolExecutor.Proxy.IThreadPoolExecutorProxy;
import com.hbwang.api.http.ApiService;

import java.util.concurrent.TimeUnit;


import retrofit.Retrofit;


/**
 * Created by Administrator on 2018/1/24.
 */

public class ApiApplication extends Application {
    private static ApiApplication mApplication;
    private static ApiService mServiceMsg;
    private static IThreadPoolExecutorProxy produce;


    /**
     * 获得当前应用全局Context
     */
    public static synchronized Context getApplication() {
        return mApplication;
    }

    /**
     * 获取全局http请求对象
     */
    public static synchronized ApiService getApiService() {
        return mServiceMsg;
    }

    /**
     * 获取全局线程池
     */
    public static synchronized IThreadPoolExecutorProxy getThreadPoolExecutorProxy() {
        return produce;
    }




    /**
     * //初始化网络请求
     */
    public static void setUrlIp(String URL) {
        mServiceMsg = getService(URL);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        setUrlIp("http://chaxun.cx580.com:9008/");                              //初始化域名
        ThreadPoolExecutorFactoryImpl threadPoolExecutorFactory = new ThreadPoolExecutorFactoryImpl();
        produce = threadPoolExecutorFactory.produce(Config.SINGLE_THREAD_EXECUTOR);                //获取线程池
        initCinfig();//初始化环境
        initData();
    }

    private void initData() {
    }

    private void initCinfig() {
    }


    /**
     * 初始化网络请求(忽略证书)
     */
    private static ApiService getService(String HOST_URL) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(30, TimeUnit.SECONDS);
        new HBWangSSLContext().ignoreCertificate(okHttpClient);
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(HOST_URL)
//                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);

    }


}
