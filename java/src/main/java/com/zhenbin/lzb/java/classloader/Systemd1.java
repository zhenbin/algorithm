package com.zhenbin.lzb.java.classloader;

/**
 * Created by zhenbin.lzb on 2016/9/6.
 */
public class Systemd1 {
    public static void print() {
        char[] a = "dfsad".toCharArray();
        System.out.println(String.valueOf(a));
    }

    public static void main(String[] args) {
        print();
        ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
    }
}
