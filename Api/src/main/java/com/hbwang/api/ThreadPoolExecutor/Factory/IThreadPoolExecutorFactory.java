package com.hbwang.api.ThreadPoolExecutor.Factory;

import com.hbwang.api.ThreadPoolExecutor.Proxy.IThreadPoolExecutorProxy;

/**
 * Created by Administrator on 2018/7/4.
 */

public interface IThreadPoolExecutorFactory {
    public IThreadPoolExecutorProxy produce(int type) throws Exception;
}
