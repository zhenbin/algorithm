package com.zhenbin.lzb.java.thread;

/**
 * Created by zhenbin.lzb on 2016/9/7.
 */
public class TimeprinterFromRunnable implements Runnable {
    private int sleepTime;

    public TimeprinterFromRunnable(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public void run() {
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I sleep " + sleepTime + "s just now.");
    }

    public static void main(String[] args) {
        Thread fastPrinter = new Thread(new TimeprinterFromRunnable(1));
        Thread slowPrinter = new Thread(new TimeprinterFromRunnable(3));
//        TimeprinterFromRunnable slowPrinter = new TimeprinterFromRunnable(3);
        fastPrinter.start();
        slowPrinter.start();
    }
}
