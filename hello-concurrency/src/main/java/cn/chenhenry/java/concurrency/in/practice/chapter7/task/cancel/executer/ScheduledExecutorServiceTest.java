package cn.chenhenry.java.concurrency.in.practice.chapter7.task.cancel.executer;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Worker implements Runnable {

    private String command;

    public Worker(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + this + " Start. Time=" + LocalDateTime.now());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " " + this + " End.   Time=" + LocalDateTime.now());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}

public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        scheduleWithDelay();
        scheduleAtRate();
    }

    public static void scheduleWithDelay() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        Worker workerThread = new Worker("do some thing with delay");
        scheduledExecutorService.scheduleWithFixedDelay(workerThread, 3000, 3000, TimeUnit.MILLISECONDS);
    }

    public static void scheduleAtRate() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        Worker workerThread = new Worker("do some thing at rate");
        scheduledExecutorService.scheduleAtFixedRate(workerThread, 3000, 3000, TimeUnit.MILLISECONDS);
    }

}
