package cn.chenhenry.hello.netty.netty.chat;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;
import sun.nio.cs.ext.MS874;

import javax.lang.model.element.VariableElement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenhanli
 * @date 2022/4/5 10:33 下午
 */
public class ChatServer {

    public static class ChatServerHandler extends SimpleChannelInboundHandler<String> {

        private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        private static final ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            Channel channel = ctx.channel();
            // 发送给客户端
            String prompt = "[客户端 " + channel.remoteAddress() + "] " + SDF.format(new Date()) + " 上线了\n";
            channelGroup.writeAndFlush(prompt);
            // 注册channel
            channelGroup.add(channel);
            // 打印到服务端
            System.out.print(prompt);
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            Channel channel = ctx.channel();
            // 发送给客户端
            String prompt = "[客户端 " + channel.remoteAddress() + "] " + SDF.format(new Date()) + " 下线了 " + "\n\n";
            channelGroup.writeAndFlush(prompt);
            // 打印到服务端
            System.out.print("channelGroup.size=" + channelGroup.size() + " " + prompt);
        }

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
            Channel channel = channelHandlerContext.channel();
            channelGroup.forEach(c -> {
                if (c != channel) {
                    // 发送给其他客户端
                    c.writeAndFlush("[客户端 " + channel.remoteAddress() + "] " + SDF.format(new Date()) + "\n<<< " + s + "\n");
                } else {
                    // 发送给自己
                    c.writeAndFlush("[我" + channel.remoteAddress() + "] " + SDF.format(new Date()) + "\n>>> " + s + "\n");
                }
            });
            System.out.print("[客户端 " + channel.remoteAddress() + "] " + SDF.format(new Date()) + " <<< " + s + "\n\n");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        // 只处理链接请求, 子线程含有1个NioEventLoop
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 处理真正的业务逻辑, 线程含有cpu核数2倍的NioEventLoop
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        // 服务端启动对象
        ServerBootstrap bootstrap = new ServerBootstrap();

        // 用链式编程来配置参数
        bootstrap
                // 设置两个线程组
                .group(bossGroup, workerGroup)
                // 服务器通道实现魏NioServerSocketChannel
                .channel(NioServerSocketChannel.class)
                // 初始化服务器连接队列大小, 服务端是顺序处理连接请求的, 同一时间只能处理一个, 其余放在队列中
                .option(ChannelOption.SO_BACKLOG, 1024)
                // 通道初始化对象
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // 设置workerGroup的SocketChannel处理器
                        socketChannel.pipeline()
                                .addLast("decoder", new StringDecoder())
                                .addLast("encoder", new StringEncoder())
                                .addLast(new ChatServerHandler());
                    }
                });

        System.out.println("netty server start...");
        // 绑定端口
        ChannelFuture cf = bootstrap
                // bind是异步操作, 所以需要后面的sync配合, 变成同步的
                .bind(9000)
                // 注册监听器
                .addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            System.out.println("监听端口成功");
                        } else {
                            System.out.println("监听端口失败");
                        }
                    }
                })
                // 需要用sync等待同步完成
                .sync();

        // 监听通道关闭, closeFuture是异步操作, 需要sync配合, 这样可以阻塞在这里等待关闭
        cf.channel().closeFuture().sync();
        System.out.println("服务端关闭");
    }
}
