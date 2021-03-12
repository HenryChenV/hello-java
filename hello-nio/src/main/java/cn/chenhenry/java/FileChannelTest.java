package cn.chenhenry.java;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @author henrychen
 * @date created at 2020/9/17 11:13 下午
 */
public class FileChannelTest {

    public static void main(String[] args) {

        try (FileChannel channel = new RandomAccessFile("test.txt", "rw") .getChannel()) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(20);

            // 1. region 写入

            // 1.1 数据写入byteBuffer
            byteBuffer.put("你好, 世界 \n".getBytes(StandardCharsets.UTF_8));

            // 1.2 准备写入

            // byteBuffer(limit = position, position = 0)
            byteBuffer.flip();

            // 移动文件指针到末尾 (追加写入)
            channel.position(channel.size());

            // 1.3 byteBuffer -> channel
            while (byteBuffer.hasRemaining()) {
                channel.write(byteBuffer);
            }

            // endregion


            // 2 region 读取

            // 2.1 准备

            // 2.1.1 移动文件指针到开头
            channel.position(0);

            // 初始化charBuffer
            CharBuffer charBuffer = CharBuffer.allocate(10);
            CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();

            // 2.1.2 清空byteBuffer (position=0, limit=capacity)
            byteBuffer.clear();

            // channel -> byteBuffer -> charBuffer
            while (channel.read(byteBuffer) != -1 || byteBuffer.position() > 0) {
                // 读取准备
                byteBuffer.flip();

                // byteBuffer -> charBuffer
                charBuffer.clear();
                decoder.decode(byteBuffer, charBuffer, false);
                System.out.println(charBuffer.flip().toString());

                byteBuffer.compact();
            }

            // endregion


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
