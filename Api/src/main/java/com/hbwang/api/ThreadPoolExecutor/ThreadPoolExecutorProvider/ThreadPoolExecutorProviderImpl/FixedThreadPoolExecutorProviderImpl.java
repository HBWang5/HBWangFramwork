package com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorProvider.ThreadPoolExecutorProviderImpl;

import com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorMsgSender.IThreadSender;
import com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorProvider.IThreadPoolExecutorProvider;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/7/4.
 */

public class FixedThreadPoolExecutorProviderImpl implements IThreadPoolExecutorProvider {

    private ExecutorService executorService;

    public FixedThreadPoolExecutorProviderImpl() {
        createThreadPool();
    }

    /**
     *  有指定的线程数的线程池，有核心的线程，
     *  里面有固定的线程数量，响应的速度快。正规的并发线程，
     *  多用于服务器。固定的线程数由系统资源设置。
     *  核心线程是没有超时机制的，队列大小没有限制，除非线程池关闭了核心线程才会被回收。
     */

    @Override
    public void createThreadPool() {
        executorService = Executors.newFixedThreadPool(3);
    }

    @Override
    public void addThread(IThreadSender iThreadSender) {
        executorService.submit(iThreadSender);
    }

    @Override
    public void addThread(Runnable iThreadSender) {
        executorService.submit(iThreadSender);
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }

}
