package cn.chenhenry.java.ocpjp.chapter11.course;

public class RunnableImpl implements Runnable {
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
        System.out.println("In run(); thread name is: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread myThread = new Thread(new RunnableImpl());
        myThread.start();
        System.out.println("In main(); thread name is: " + Thread.currentThread().getName());
    }
}
