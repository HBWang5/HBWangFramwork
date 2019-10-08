package com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorProvider.ThreadPoolExecutorProviderImpl;

import com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorMsgSender.IThreadSender;
import com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorProvider.IThreadPoolExecutorProvider;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/7/4.
 */

public class SingleThreadExecutorProviderImpl implements IThreadPoolExecutorProvider {

    private ExecutorService executorService;

    public SingleThreadExecutorProviderImpl() {
        createThreadPool();
    }

    /**
     * 只有一个核心线程，通过指定的顺序将任务一个个丢到线程，
     * 都乖乖的排队等待执行，不处理并发的操作，不会被回收。
     */

    @Override
    public void createThreadPool() {
        executorService = Executors.newSingleThreadExecutor();
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
