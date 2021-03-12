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

    public static void main(String[] args) {
        Thread thread1 = new Thread1(object);
        Thread thread2 = new Thread2(object);

        thread1.start();

        // try {
        //     Thread.sleep(200);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        thread2.start();
    }
}
