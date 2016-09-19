package com.zhenbin.lzb.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhenbin.lzb on 2016/9/8.
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
//      Executors ��ʹ�� ExecutorService  �ṩ��һ�� ThreadPoolExecutor �ļ�ʵ�֣�
// �� ThreadPoolExecutor �ṩ�Ĺ���Զ��ֹ��Щ��
        /**
         * Executors ��ʹ�� ExecutorService  �ṩ��һ�� ThreadPoolExecutor �ļ�ʵ�֣�
         * �� ThreadPoolExecutor �ṩ�Ĺ���Զ��ֹ��Щ��
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
