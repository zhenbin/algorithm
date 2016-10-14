package com.zhenbin.lzb.java.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by melon on 16/9/18.
 * <p>
 * http://ifeve.com/java-nio-scattergather/
 */
public class ChannelDemo2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("data/header-data.txt", "rw");
        FileChannel inChannel = randomAccessFile.getChannel();

        ByteBuffer header = ByteBuffer.allocate(8);
        ByteBuffer content = ByteBuffer.allocate(13);
        ByteBuffer[] bufferArray = {header, content};
        long readBytes = inChannel.read(bufferArray);
        while (readBytes != -1L) {
            //读header的内容
            System.out.print("header : ");
            header.flip();                              //flip切换成读模式，不然会出错的。
            while (header.hasRemaining()) {
                //byte是单字节的；header-data是utf8编码的，对于英语文本，utf8只占用一个字节。
                System.out.print((char) header.get());
            }
            System.out.println();
            header.clear();

            //读content的内容
            System.out.print("content : ");
            content.flip();
            while (content.hasRemaining()) {
                System.out.print((char) content.get());
            }
            System.out.println();
            content.clear();
            readBytes = inChannel.read(bufferArray);
//            Objects.equals("234", "323");
        }
    }
}
