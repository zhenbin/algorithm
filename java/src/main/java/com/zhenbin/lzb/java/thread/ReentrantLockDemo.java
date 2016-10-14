package com.zhenbin.lzb.java.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhenbin.lzb on 2016/10/8.
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        /**
         * 1. 可重复加锁(reentrant，不仅是互斥而已)
         * 2. 其它线程只能在获得锁后才能上锁和卸锁
         */
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lock();
//            可重复加锁
            reentrantLock.lock();
        }
        finally {
            reentrantLock.unlock();
            System.out.println(reentrantLock.isLocked());
            reentrantLock.unlock();
            System.out.println(reentrantLock.isLocked());
        }
    }
}
