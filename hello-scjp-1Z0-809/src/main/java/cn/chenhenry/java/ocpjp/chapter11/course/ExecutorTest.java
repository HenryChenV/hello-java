package cn.chenhenry.java.ocpjp.chapter11.course;


import java.util.concurrent.Executor;

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Calling Task.run() ");
    }
}


class RepeatedExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }

    public void execute(Runnable command, int times) {
        System.out.printf("Calling Task.run() %d times thro' Executor.execute() \n", times);
        for (int i = 0; i < times; i++) {
            execute(command);
        }
    }
}


public class ExecutorTest {
    public static void main(String[] args) {
        // Runnable runnable = () -> System.out.println("hello");
        Runnable runnable = new Task();

        System.out.println("Calling Task.run() by directly creating a Thread");
        new Thread(runnable).start();

        new RepeatedExecutor().execute(runnable, 3);
    }
}
