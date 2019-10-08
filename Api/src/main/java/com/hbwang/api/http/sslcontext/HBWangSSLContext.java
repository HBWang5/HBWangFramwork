package com.hbwang.api.http.sslcontext;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/4/10-10:28
 */
public class HBWangSSLContext {
    TrustManager[] trustManager = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws
                        CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws
                        CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;    // 返回null
                }
            }
    };
    public HBWangSSLContext() {
    }

    public void ignoreCertificate(com.squareup.okhttp.OkHttpClient okHttpClient) {
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustManager, new SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        okHttpClient.setSslSocketFactory(sslSocketFactory);
        okHttpClient.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
    }

}
