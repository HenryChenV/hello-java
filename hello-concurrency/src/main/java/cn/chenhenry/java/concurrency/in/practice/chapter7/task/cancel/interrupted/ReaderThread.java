package cn.chenhenry.java.concurrency.in.practice.chapter7.task.cancel.interrupted;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 通过改写interrupt方法将非标准的取消操作封装在Thead中
 * @author henrychen
 */
public class ReaderThread extends Thread {

    private static final int BUFSZ = 102400;

    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    @Override
    public void interrupt() {
        try {
            socket.close();
        } catch (IOException ignored) {
        } finally {
            super.interrupt();
        }
    }

    @Override
    public void run() {
        byte[] buf = new byte[BUFSZ];
        try {
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else if (count > 0) {
                    processBuffer(buf, count);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processBuffer(byte[] buf, int count) {
    }
}
