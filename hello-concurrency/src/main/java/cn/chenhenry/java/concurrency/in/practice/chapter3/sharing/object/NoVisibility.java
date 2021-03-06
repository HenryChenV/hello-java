package cn.chenhenry.java.concurrency.in.practice.chapter3.sharing.object;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println("yield");
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();

        number = 42;
        ready = true;
    }
}
