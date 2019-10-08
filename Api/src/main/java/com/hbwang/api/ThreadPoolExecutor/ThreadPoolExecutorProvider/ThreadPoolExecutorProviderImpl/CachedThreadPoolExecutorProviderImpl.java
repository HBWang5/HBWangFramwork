package com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorProvider.ThreadPoolExecutorProviderImpl;

import com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorMsgSender.IThreadSender;
import com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorProvider.IThreadPoolExecutorProvider;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Administrator on 2018/7/4.
 */

public class CachedThreadPoolExecutorProviderImpl implements IThreadPoolExecutorProvider {

    private ExecutorService executorService;

    public CachedThreadPoolExecutorProviderImpl() {
        createThreadPool();
    }

    /**
     * 只有非核心线程，最大线程数很大（Int.Max(values)），
     * 它会为每一个任务添加一个新的线程，这边有一个超时机制，
     * 当空闲的线程超过60s内没有用到的话，就会被回收。缺点就是没有考虑到系统的实际内存大小。
     */
    @Override
    public void createThreadPool() {
        executorService = Executors.newCachedThreadPool();
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
