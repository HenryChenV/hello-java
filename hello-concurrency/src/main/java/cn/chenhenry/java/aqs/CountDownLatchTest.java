package cn.chenhenry.java.aqs;

import sun.java2d.SurfaceDataProxy;

import java.util.concurrent.CountDownLatch;

/**
 * @author henrychen
 * @date created at 2020/12/20 11:42 下午
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                // 减一
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " counts = " + countDownLatch.getCount());

                try {
                    // 阻塞等待state=0
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end");
            }).start();
        }
    }

}
