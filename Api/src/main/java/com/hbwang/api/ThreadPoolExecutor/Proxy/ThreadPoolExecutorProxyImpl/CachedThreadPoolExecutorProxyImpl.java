package com.hbwang.api.ThreadPoolExecutor.Proxy.ThreadPoolExecutorProxyImpl;

import com.hbwang.api.ThreadPoolExecutor.Proxy.IThreadPoolExecutorProxy;
import com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorMsgSender.IThreadSender;
import com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorProvider.IThreadPoolExecutorProvider;
import com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorProvider.ThreadPoolExecutorProviderImpl.CachedThreadPoolExecutorProviderImpl;

/**
 * Created by Administrator on 2018/7/4.
 */

public class CachedThreadPoolExecutorProxyImpl implements IThreadPoolExecutorProxy {
    private IThreadPoolExecutorProvider threadPoolExecutorProvider;

    /**
     *  具体产品
     */
    public CachedThreadPoolExecutorProxyImpl() {
        createThreadPool();
    }

    @Override
    public void createThreadPool() {
        threadPoolExecutorProvider = new CachedThreadPoolExecutorProviderImpl();
    }

    @Override
    public void addThread(IThreadSender iThreadSender) {
        threadPoolExecutorProvider.addThread(iThreadSender);
    }

    @Override
    public void addThread(Runnable iThreadSender) {
        threadPoolExecutorProvider.addThread(iThreadSender);
    }

    @Override
    public void shutdown() {
        threadPoolExecutorProvider.shutdown();
    }

}
