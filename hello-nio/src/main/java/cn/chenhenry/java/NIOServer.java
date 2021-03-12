package cn.chenhenry.java;

import javax.swing.text.html.HTMLDocument;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 很粗糙
 *
 * @author henrychen
 * @date created at 2020/9/18 4:33 下午
 */
public class NIOServer {

    private static final int LISTEN_PORT = 9999;

    private static final byte PACKET_ENDING = (byte) '\n';

    /**
     * @param args
     */
    public static void main(String[] args) {

        // 初始化 selector
        try (Selector selector = Selector.open()) {
            // 初始化监听通道
            ServerSocketChannel listenChannel = ServerSocketChannel.open();
            listenChannel.bind(new InetSocketAddress(LISTEN_PORT));
            listenChannel.configureBlocking(false);

            // 注册到selector，监听ACCEPT事件
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer buffer = ByteBuffer.allocate(100);

            while (true) {
                // 阻塞，等待就绪事件
                System.out.println("selecting...");
                selector.select();

                // 处理就绪事件
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();

                    System.out.println("开始处理，key=" + key);

                    if (key.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();

                        System.out.println(String.format(
                                "channel[ip=%s]有accept事件", serverSocketChannel.getLocalAddress()));

                        SocketChannel socketChannel = serverSocketChannel.accept();

                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);

                        System.out.println(String.format(
                                "与channel[localIp=%s, remoteIp=%s]建立了连接",
                                socketChannel.getLocalAddress(), socketChannel.getRemoteAddress()));

                    } else if (key.isReadable()) {
                        buffer.clear();
                        SocketChannel socketChannel = (SocketChannel) key.channel();

                        // -1说明socket已断开, 于是也断开本地的socket
                        if (-1 == socketChannel.read(buffer)) {
                            key.channel().close();
                            continue;
                        }

                        // 读取内容
                        buffer.flip();
                        char[] request = new char[100];
                        int i = 0;
                        while (buffer.hasRemaining()) {
                            byte b = buffer.get();
                            request[i++] = (char) b;

                            // 0是服务段和客户端约定的数据结束的标志
                            // 也可以是其他标志
                            if (PACKET_ENDING == b) {
                                System.out.println("Client says: " + new String(request));

                                System.out.println("响应客户端");

                                // 响应数据写入buffer
                                buffer.clear();
                                buffer.put("Hello, Client \n".getBytes());

                                // 发送响应数据
                                buffer.flip();
                                while (buffer.hasRemaining()) {
                                    socketChannel.write(buffer);
                                }

                            }

                        }

                    } else if (key.isWritable()) {

                    } else if (key.isWritable()) {

                    } else if (key.isConnectable()) {

                    }

                    // 已处理的事件需要移除
                    System.out.println("处理完成，移除key");
                    iterator.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
