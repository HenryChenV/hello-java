package cn.chenhenry.hello.netty.multiplexing;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author chenhanli
 * @date 2022/3/27 9:19 下午
 */
public class NIOSelectorServer {
    public static void main(String[] args) throws IOException {
        // 创建NIO Server Socket Channel，类似于BIO Server Socket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));

        // 设置Server Socket Channel为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 创建处理Channel的Selector, 即epoll
        Selector selector = Selector.open();

        // 把server socket channel注册到selector上, 并关注accept事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务启动成功");

        // 处理请求
        while (true) {
            // 阻塞到有事件发生
            selector.select();

            // 获取所有事件
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();

            // 事件处理
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    // OP_ACCEPT, 获取连接, 然后注册事件

                    // 其实这里的channel就是最开始new的那个ServerSocketChannel
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel clientSocketChannel = server.accept();
                    clientSocketChannel.configureBlocking(false);

                    clientSocketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("客户端注册成功");

                } else if (selectionKey.isReadable()) {
                    // OP_READ, 读取数据

                    SocketChannel channel = (SocketChannel) selectionKey.channel();

                    ByteBuffer buf = ByteBuffer.allocate(128);
                    int len = channel.read(buf);

                    if (len > 0) {
                        System.out.println("收到消息: " + new String(buf.array(), 0, len));
                        channel.write(ByteBuffer.wrap("Hello Client".getBytes()));

                    } else if (len == -1) {
                        System.out.println("客户端断开连接");
                        channel.close();
                    }
                }

                // 删除key, 防止下次select重复处理
                try {
                    iterator.remove();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e);
                }
            }
        }
    }
}
