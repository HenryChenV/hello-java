package cn.chenhenry.java.aqs;

import cn.chenhenry.java.waitnotify.Thread1;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.TreeMap;
import java.util.concurrent.Semaphore;

/**
 * @author henrychen
 * @date created at 2020/12/20 11:06 下午
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        // 声明3个窗口(资源数3)
        Semaphore windows = new Semaphore(3);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    // 占用窗口
                    windows.acquire();
                    System.out.println(Thread.currentThread().getId() + ": 开始买票");
                    // 模拟买票流程
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getId() + ": 购票成功");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放窗口
                    windows.release();
                }
            }).start();
        }
    }

}
