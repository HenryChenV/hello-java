package cn.chenhenry.java.waitnotify;

/**
 * @author henrychen
 * @date created at 2020/12/16 12:10 上午
 */
public class Thread1 extends Thread {

    private final Object lock;

    public Thread1(Object object) {
        lock = object;
    }

    @Override
    public void run() {
        System.out.println("进入线程" + Thread.currentThread().getName());
        // 如果没有synchronized会报Exception in thread "Thread-1" java.lang.IllegalMonitorStateException
        // 因为Object.wait的执行必须要获取对象的monitor
        synchronized (lock) {
            try {
                lock.wait();
                // 这个时候已经把锁交出去, 并阻塞在这儿了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "获得了锁.");
        }
    }
}
