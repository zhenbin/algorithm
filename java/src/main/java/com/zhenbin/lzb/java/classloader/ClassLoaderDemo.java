package com.zhenbin.lzb.java.classloader;

/**
 * Created by zhenbin.lzb on 2016/9/6.
 */
//com.zhenbin.lzb.java.classloader.ClassLoaderDemo
public class ClassLoaderDemo {
    public static void main(String[] args) {
        /**
         * 输出为sun.misc.Launcher$AppClassLoader@42a57993
         * 可以看出ClassLoader类是由AppClassLoader加载的
         */
        String paths = System.getProperty("java.class.path");
        for (String path : paths.split(";")) {
            System.out.println(path);
        }
        System.out.println(ClassLoader.getSystemClassLoader());

    }
}
