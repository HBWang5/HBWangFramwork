package com.hbwang.api.base.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.hbwang.api.config.Config;
import com.hbwang.api.ThreadPoolExecutor.Factory.ThreadPoolExecutorFactoryImpl.ThreadPoolExecutorFactoryImpl;
import com.hbwang.api.ThreadPoolExecutor.Proxy.IThreadPoolExecutorProxy;
import com.hbwang.api.http.ApiService;
import com.hbwang.api.net.converter.HBWangConverterFactory;

import java.net.Proxy;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;


import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


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
        CrashHandler.getInstance(this);
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
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .proxy(Proxy.NO_PROXY);
        X509TrustManager x509TrustManager = new X509TrustManager() {
            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[]{};
            }
        };

        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{x509TrustManager}, new java.security.SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(HBWangConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(HOST_URL)
                .build();
        return retrofit.create(ApiService.class);

    }


}
