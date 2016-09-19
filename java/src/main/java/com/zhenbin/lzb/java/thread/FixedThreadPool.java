package com.zhenbin.lzb.java.thread;

import java.util.concurrent.*;

/**
 * Created by zhenbin.lzb on 2016/9/9.
 * <p>
 * 1. 如果线程数小于corePoolSize，直接分配一个新线程运行任务；
 * 2. 如果线程数大于等于corePoolSize，直接加到任务队列；
 * 3. 如果加不进任务队列，且线程数小于maximumPoolSize，则创建新的线程运行任务。
 * 4. 如果这样都不行，那么按照策略处理无法执行的任务。默认策略是抛异常。
 */
public class FixedThreadPool {

    public static void noQueueLimitExecutor() {
        //虽然最大是100，但也没什么用，因为是无界队列，所以可以成功加入队列，而不用去执行第三步
        ExecutorService noLimitExecutor = new ThreadPoolExecutor(1, 100, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 30; i++) {
            noLimitExecutor.execute(new Timeprinter("" + i));
        }
    }

    public static void noPoolLimitExecutor() {
        ExecutorService noPoolLimitExecutor = new ThreadPoolExecutor(2, 3, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 4; i++) {
            // i = 3的时候会抛异常，因为这个时候没有空闲的线程可以从队列里取东西，所以放不进队列里；
            // 又因为已经达到最大线程数，所以无法再创建新线程，于是执行默认的异常处理行为。
            noPoolLimitExecutor.execute(new Timeprinter("" + i));
        }
        noPoolLimitExecutor.shutdown();
    }


    public static void main(String[] args) {
//        noQueueLimitExecutor();
        noPoolLimitExecutor();

    }
}
