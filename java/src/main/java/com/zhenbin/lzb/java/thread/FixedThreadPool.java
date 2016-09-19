package com.zhenbin.lzb.java.thread;

import java.util.concurrent.*;

/**
 * Created by zhenbin.lzb on 2016/9/9.
 * <p>
 * 1. ����߳���С��corePoolSize��ֱ�ӷ���һ�����߳���������
 * 2. ����߳������ڵ���corePoolSize��ֱ�Ӽӵ�������У�
 * 3. ����Ӳ���������У����߳���С��maximumPoolSize���򴴽��µ��߳���������
 * 4. ������������У���ô���ղ��Դ����޷�ִ�е�����Ĭ�ϲ��������쳣��
 */
public class FixedThreadPool {

    public static void noQueueLimitExecutor() {
        //��Ȼ�����100����Ҳûʲô�ã���Ϊ���޽���У����Կ��Գɹ�������У�������ȥִ�е�����
        ExecutorService noLimitExecutor = new ThreadPoolExecutor(1, 100, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 30; i++) {
            noLimitExecutor.execute(new Timeprinter("" + i));
        }
    }

    public static void noPoolLimitExecutor() {
        ExecutorService noPoolLimitExecutor = new ThreadPoolExecutor(2, 3, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 4; i++) {
            // i = 3��ʱ������쳣����Ϊ���ʱ��û�п��е��߳̿��ԴӶ�����ȡ���������ԷŲ��������
            // ����Ϊ�Ѿ��ﵽ����߳����������޷��ٴ������̣߳�����ִ��Ĭ�ϵ��쳣������Ϊ��
            noPoolLimitExecutor.execute(new Timeprinter("" + i));
        }
        noPoolLimitExecutor.shutdown();
    }


    public static void main(String[] args) {
//        noQueueLimitExecutor();
        noPoolLimitExecutor();

    }
}
