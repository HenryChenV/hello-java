package cn.chenhenry.java.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author henrychen
 * @date created at 2020/12/20 4:10 下午
 */
public class ReentrantLockTest {

    private static int sum = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    for (int j = 0; j < 10000; j++) {
                        sum++;
                    }
                } finally {
                    lock.unlock();
                }
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sum);
    }

}
