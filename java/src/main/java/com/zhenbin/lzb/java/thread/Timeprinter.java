package com.zhenbin.lzb.java.thread;

/**
 * Created by zhenbin.lzb on 2016/9/7.
 */
public class Timeprinter extends Thread {

    private String name;

    public Timeprinter(String name) {
        this.name = name;
    }

    public void printa() {
        System.out.println(name + ": a");
    }

    public void printb() {
        System.out.println(name + ": b");
    }

    @Override
    public void run() {
        try {
            printa();
            Thread.sleep(500000);
            printb();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}
