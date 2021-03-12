package cn.chenhenry.java.waitnotify;

/**
 * @author henrychen
 * @date created at 2020/12/16 12:12 上午
 */
public class Thread2 extends Thread {

    private final Object lock;

    public Thread2(Object object) {
        lock = object;
    }

    @Override
    public void run() {
        System.out.println("进入线程" + Thread.currentThread().getName());
        // 如果没有synchronized会报Exception in thread "Thread-1" java.lang.IllegalMonitorStateException
        // 因为Object.wait的执行必须要获取对象的monitor
        synchronized (lock) {
            lock.notify();
            System.out.println("线程"+Thread.currentThread().getName()+"调用了object.notify()");
        }

        System.out.println("线程"+Thread.currentThread().getName()+"释放了锁");
    }
}
