package cn.chenhenry.java.waitnotify;

/**
 * wait notify
 *
 * 1）wait()、notify()和notifyAll()方法是本地方法，并且为final方法，无法被重写。
 * 2）调用某个对象的wait()方法能让当前线程阻塞，并且当前线程必须拥有此对象的monitor（即锁）
 * 3）调用某个对象的notify()方法能够唤醒一个正在等待这个对象的monitor的线程，如果有多个线程都在等待这个对象的monitor，则只能唤醒其中一个线程；
 * 4）调用notifyAll()方法能够唤醒所有正在等待这个对象的monitor的线程；
 *
 * 如果调用某个对象的wait()方法，当前线程必须拥有这个对象的monitor（即锁），
 * 因此调用wait()方法必须在同步块或者同步方法中进行（synchronized块或者synchronized方法）。
 *
 * 上面尤其要注意一点，一个线程被唤醒不代表立即获取了对象的monitor，
 * 只有等调用完notify()或者notifyAll()并退出synchronized块，
 * 释放对象锁后，其余线程才可获得锁执行。
 *
 * 参考: https://www.cnblogs.com/dolphin0520/p/3920385.html
 */
public class WaitNotifyTest {
    private static final Object object = new Object();

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("进入线程" + Thread.currentThread().getName());
            // 如果没有synchronized会报Exception in thread "Thread-1" java.lang.IllegalMonitorStateException
            // 因为Object.wait的执行必须要获取对象的monitor
            synchronized (object) {
                try {
                    object.wait();
                    // 这个时候已经把锁交出去, 并阻塞在这儿了
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获得了锁.");
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println("进入线程" + Thread.currentThread().getName());
            // 如果没有synchronized会报Exception in thread "Thread-1" java.lang.IllegalMonitorStateException
            // 因为Object.wait的执行必须要获取对象的monitor
            synchronized (object) {
                object.notify();
                System.out.println("线程"+Thread.currentThread().getName()+"调用了object.notify()");
            }

            System.out.println("线程"+Thread.currentThread().getName()+"释放了锁");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();

        thread1.start();

        // try {
        //     Thread.sleep(200);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        thread2.start();
    }
}
