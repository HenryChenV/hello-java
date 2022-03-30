package cn.chenhenry.hello.netty.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chenhanli
 * @date 2022/3/27 8:48 下午
 */
public class NIOServer {

    private static final List<SocketChannel> clientSocketChannelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 创建NIO Server Socket Channel，类似于BIO Server Socket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));

        // 设置Server Socket Channel为非阻塞
        serverSocketChannel.configureBlocking(false);
        System.out.println("服务启动成功");

        while (true) {
            // 非阻塞模式的accept不会阻塞, 底层调用了Linux内核的accept函数, 是非阻塞的
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            if (clientSocketChannel != null) {
                // 说明有客户端连接
                clientSocketChannel.configureBlocking(false);
                // 保存客户端连接到list中
                clientSocketChannelList.add(clientSocketChannel);
            }

            // 遍历连接读取数据
            Iterator<SocketChannel> iterator = clientSocketChannelList.iterator();
            while (iterator.hasNext()) {
                SocketChannel sc = iterator.next();
                ByteBuffer buf = ByteBuffer.allocate(128);

                int len = sc.read(buf);
                if (len> 0) {
                    System.out.println("接收到消息: " + new String(buf.array(), 0, len));
                    sc.write(ByteBuffer.wrap("Hello Client".getBytes()));

                } else if (-1 == len) {
                    // 说明客户端断开连接
                    iterator.remove();
                    System.out.println("客户端断开连接");
                }
            }

        }
    }
}
