package cn.chenhenry.java.concurrency.in.practice.chapter7.task.cancel;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

/**
 * 带有可靠取消逻辑的日志服务
 *
 * 注意点：
 * 1. 如果立即取消，可能会丢失一部分日志数据
 * 2. 实现中用到了BlockingQueue，如何防止因为BlockingQueue的阻塞而无法取消的情况
 * 3. 取消时如何通知到日志生产者
 */
public class LogService {

    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private final PrintWriter writer;

    /**
     * 关闭标志
     */
    private boolean isShutdown;
    /**
     * 剩余日志数量
     */
    private int reservations;

    public LogService(BlockingQueue<String> queue, PrintWriter writer) {
        this.queue = queue;
        this.loggerThread = new LoggerThread();
        this.writer = writer;
    }

    public void start() {
        loggerThread.start();
    }

    public void stop() {
        synchronized (this) {
            isShutdown = true;
            loggerThread.interrupt();
        }
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown) {
                throw new IllegalStateException("logger is shutdown.");
            }
            ++reservations;
        }
        queue.put(msg);
    }

    private class LoggerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    try {
                        // 多线程时对reservations的操作必须是可见的
                        synchronized (LogService.this) {
                            if (isShutdown && reservations == 0) {
                                break;
                            }
                        }

                        String msg = queue.take();

                        // 多线程时对reservations的操作必须是可见的
                        // 使用volatile关键字仅能实现对原始变量(如boolen、 short 、int 、long等)操作的原子性，
                        // 但需要特别注意， volatile不能保证复合操作的原子性，
                        // 即使只是i++，实际上也是由多个原子操作组成：read i; inc; write i，
                        // 假如多个线程同时执行i++，volatile只能保证他们操作的i是同一块内存，
                        // 但依然可能出现写入脏数据的情况。
                        synchronized (LogService.this) {
                            --reservations;
                        }

                        writer.println(msg);
                    } catch (InterruptedException e) {
                        // retry
                    }
                }
            } finally {

            }
        }
    }
}
