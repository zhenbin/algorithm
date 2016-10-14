package com.zhenbin.lzb.java.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by melon on 16/9/19.
 *
 * Java NIO系列教程（六） Selector
 * http://ifeve.com/selectors/
 *
 * 使用selector的好处：更少的线程来处理多个通道。这样避免线程上下文切换带来的开销。
 *
 * selector不能和FileChannel一起使用，因为FileChannel不能切换成非阻塞模式。
 *
 *
 */
public class ChannelDemo4 {


    public static void main(String[] args) throws IOException {
        double i = 0.1;
        System.out.println("\tabc\rbc");
    }
}
