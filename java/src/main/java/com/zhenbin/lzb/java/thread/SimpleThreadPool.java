package com.zhenbin.lzb.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhenbin.lzb on 2016/9/8.
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
//      Executors 类使用 ExecutorService  提供了一个 ThreadPoolExecutor 的简单实现，
// 但 ThreadPoolExecutor 提供的功能远不止这些。
        /**
         * Executors 类使用 ExecutorService  提供了一个 ThreadPoolExecutor 的简单实现，
         * 但 ThreadPoolExecutor 提供的功能远不止这些。
         *
         * public static ExecutorService newFixedThreadPool(int nThreads) {
             return new ThreadPoolExecutor(nThreads, nThreads,
             0L, TimeUnit.MILLISECONDS,
             new LinkedBlockingQueue<Runnable>());
          }
         */
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable printer = new Timeprinter("" + i);
            executor.execute(printer);
        }
        executor.shutdown();
    }
}
