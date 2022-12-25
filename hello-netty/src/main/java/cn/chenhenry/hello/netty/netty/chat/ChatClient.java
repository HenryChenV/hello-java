package cn.chenhenry.hello.netty.netty.chat;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import javax.crypto.MacSpi;
import java.util.Scanner;


/**
 * @author chenhanli
 * @date 2022/4/5 11:32 下午
 */
public class ChatClient {

    public static class ChatClientHandler extends SimpleChannelInboundHandler<String> {

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
            System.out.println(s);
        }

        /**
         * 出现异常, 关闭
         */
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
            System.out.println("客户端异常关闭");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        // 客户端的启动器是Bootstrap而不是ServerBootstrap
        Bootstrap bootstrap = new Bootstrap();

        // 配置启动器
        bootstrap
                .group(group)
                // 设置客户端通道实现为NioServerSocketChannel
                .channel(NioSocketChannel.class)
                // 初始化器
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // 加入处理器
                        socketChannel.pipeline()
                                .addLast(new StringEncoder())
                                .addLast(new StringDecoder())
                                .addLast(new ChatClientHandler());
                    }
                });

        System.out.println("netty client start");

        // 连接服务端
        final ChannelFuture cf = bootstrap.connect("127.0.0.1", 9000).sync();

        Channel channel = cf.channel();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            channel.writeAndFlush(msg);
        }

        // 监听通道关闭
        cf.channel().closeFuture().sync();
        System.out.println("客户端关闭");
    }
}
