package com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorProvider;

import com.hbwang.api.ThreadPoolExecutor.ThreadPoolExecutorMsgSender.IThreadSender;

/**
 * Created by Administrator on 2018/6/28.
 */

public interface IThreadPoolExecutorProvider {
    void createThreadPool();
    void addThread(IThreadSender iThreadSender);
    void addThread(Runnable iThreadSender);
    void shutdown();
}
