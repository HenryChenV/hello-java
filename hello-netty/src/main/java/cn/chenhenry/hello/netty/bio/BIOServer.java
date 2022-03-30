package cn.chenhenry.hello.netty.bio;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenhanli
 * @date 2022/3/27 11:04 上午
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接...");

            // 阻塞方法
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了: " +
                    "ip=" + clientSocket.getInetAddress().getHostAddress() +
                    ", port=" + clientSocket.getPort());

            handle(clientSocket);
        }
    }

    private static void handle(Socket clientSocket) throws IOException {
        byte[] buf = new byte[1024];
        System.out.println("准备read...");

        int read = clientSocket.getInputStream().read(buf);
        System.out.println("read完毕");
        if (-1 != read) {
            System.out.println("接收到客户端数据: " + new String(buf, 0, read));
        }

        clientSocket.getOutputStream().write("Hello Client".getBytes());
        clientSocket.getOutputStream().flush();
    }
}
