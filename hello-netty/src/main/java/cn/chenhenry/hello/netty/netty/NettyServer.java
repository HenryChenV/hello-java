package cn.chenhenry.hello.netty.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

/**
 * @author chenhanli
 * @date 2022/4/5 10:33 下午
 */
public class NettyServer {

    public static class NettyServerHandler extends ChannelInboundHandlerAdapter {

        /**
         * 读取客户端发送的数据
         * @param ctx 上下文对象, 包含channel和pipeline
         * @param msg 客户端发送的数据
         * @throws Exception
         */
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("服务器读线程" + Thread.currentThread());
            // 将msg转成一个ByteBuf, 类似NIO的ByteBuffer
            ByteBuf buf = (ByteBuf) msg;
            System.out.println("客户端发送的消息是: " + buf.toString(CharsetUtil.UTF_8));
        }

        /**
         * 数据读取完毕处理方法
         * @param ctx
         * @throws Exception
         */
        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            ByteBuf buf = Unpooled.copiedBuffer("Hello Client", CharsetUtil.UTF_8);
            ctx.writeAndFlush(buf);
        }

        /**
         * 处理异常, 一般需要关闭通道
         * @param ctx
         * @param cause
         * @throws Exception
         */
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.close();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        // 主从Reactor模型中的主, 只处理连接请求, 1个线程
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 主从Reactor模型中的从, 处理真正的业务逻辑, 线程默认为cpu核数2倍
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        // 服务端启动对象
        ServerBootstrap bootstrap = new ServerBootstrap();

        // 用链式编程来配置参数
        bootstrap
                // 设置两个线程组
                .group(bossGroup, workerGroup)
                .localAddress(9000)
                // 服务器通道实现为NioServerSocketChannel
                .channel(NioServerSocketChannel.class)
                // 初始化服务器连接队列大小, 服务端是顺序处理连接请求的, 同一时间只能处理一个, 其余放在队列中
                .option(ChannelOption.SO_BACKLOG, 1024)
                // 通道初始化对象
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // 设置workerGroup的SocketChannel处理器
                        socketChannel.pipeline().addLast(new NettyServerHandler());
                    }
                });

        System.out.println("netty server start...");
        // 绑定端口
        ChannelFuture cf = bootstrap
                // bind是异步操作, 所以需要后面的sync配合, 变成同步的
                .bind()
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
