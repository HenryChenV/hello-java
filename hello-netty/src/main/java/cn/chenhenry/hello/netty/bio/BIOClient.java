package cn.chenhenry.hello.netty.bio;


import java.io.IOException;
import java.net.Socket;
import java.util.logging.SocketHandler;

/**
 * @author chenhanli
 * @date 2022/3/27 11:27 上午
 */
public class BIOClient {
    public static void main(String[] args) throws IOException {
        Socket serverSocket = new Socket("localhost", 9000);

        // 向服务端发送数据
        serverSocket.getOutputStream().write("Hello Server".getBytes());
        serverSocket.getOutputStream().flush();
        System.out.println("向服务端发送数据结束");

        // 接收服务端数据
        byte[] buf = new byte[1024];
        int read = serverSocket.getInputStream().read(buf);
        System.out.println("接收到服务端数据: " + new String(buf, 0, read));
        serverSocket.close();
    }
}
