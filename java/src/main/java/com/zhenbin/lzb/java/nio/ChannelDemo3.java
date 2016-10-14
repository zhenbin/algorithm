package com.zhenbin.lzb.java.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by melon on 16/9/19.
 *
 * Java NIO系列教程（五） 通道之间的数据传输
 * http://ifeve.com/java-nio-channel-to-channel/
 */
public class ChannelDemo3 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("data/nio-data.txt", "r");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("data/new-data.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        toChannel.transferFrom(fromChannel, 0, fromChannel.size());

        fromChannel.close();
        toChannel.close();
    }
}
