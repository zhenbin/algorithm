package com.zhenbin.lzb.java.thread;

/**
 * Created by zhenbin.lzb on 2016/9/7.
 */
public class Timeprinter extends Thread {
    private int sleepTime;

    public Timeprinter(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public void printa() {
        synchronized (Timeprinter.class) {
            try {
                Thread.sleep(sleepTime * 5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("a");
        }
    }

    public static synchronized void printb() {
        System.out.println("b");
    }

    @Override
    public void run() {
        try {
            printa();
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I sleep " + sleepTime + "s just now.");
    }

    public static void main(String[] args) {
        Timeprinter fastPrinter = new Timeprinter(1);
//        Timeprinter slowPrinter = new Timeprinter(3);
        fastPrinter.start();

        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < 10; i++)
        System.out.println("haha");
        fastPrinter.printb();

//        slowPrinter.start();
    }
}
