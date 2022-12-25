package cn.chenhenry.hello.netty.netty;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;


/**
 * @author chenhanli
 * @date 2022/4/5 11:32 下午
 */
public class NettyClient {

    public static class NettyClientHandler extends ChannelInboundHandlerAdapter {
        /**
         * 客户端连接服务器完成时触发
         */
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("连接成功");
            ByteBuf buf = Unpooled.copiedBuffer("HelloServer", CharsetUtil.UTF_8);
            ctx.writeAndFlush(buf);
        }

        /**
         * 有读取事件时触发, 即服务器发送数据给客户端
         */
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;
            System.out.println("收到服务端[" + ctx.channel().remoteAddress() + "]消息: " + buf.toString(CharsetUtil.UTF_8));
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
                        socketChannel.pipeline().addLast(new NettyClientHandler());
                    }
                });

        System.out.println("netty client start");

        // 连接服务端
        final ChannelFuture cf = bootstrap.connect("127.0.0.1", 9000).sync();

        // 监听通道关闭
        cf.channel().closeFuture().sync();
        System.out.println("客户端关闭");
    }
}
