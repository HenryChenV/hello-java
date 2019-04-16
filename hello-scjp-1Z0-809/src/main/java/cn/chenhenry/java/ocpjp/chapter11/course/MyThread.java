package cn.chenhenry.java.ocpjp.chapter11.course;

public class MyThread extends Thread {
    @Override
    public void run () {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("In run(); thread name is: " + getName());
    }

    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();
        System.out.println("In main(); thread name: " + Thread.currentThread().getName());
    }
}
