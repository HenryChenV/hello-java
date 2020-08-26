package cn.chenhenry.java.ocpjp.chapter11.course;

class Counter {
    public static long count = 0;

    Counter() {
        Counter.count++;
        System.out.printf(Counter.count + " ");
    }
}


class UseCounter implements Runnable {

    UseCounter() {
        new Counter();
    }

    /**
     * synchronized block
     */
    private void doIncrement1() {
        synchronized (this) {
            Counter.count++;
            System.out.printf(Counter.count + " ");
        }
    }

    /**
     * synchronized method
     */
    private synchronized void doIncrement2() {
        Counter.count++;
        System.out.printf(Counter.count + " ");
    }

    /**
     * constructors is synchronized implicitly
     */
    private void doIncrement3() {
        new UseCounter();
    }

    private void increment() {
        doIncrement3();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        increment();
        increment();
        increment();
    }
}


public class RaceCondition {
    public static void main(String[] args) {
        UseCounter c = new UseCounter();

        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);

        t1.start();
        t2.start();
        t3.start();
    }
}
