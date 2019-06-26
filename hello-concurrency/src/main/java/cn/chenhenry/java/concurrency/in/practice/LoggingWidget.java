package cn.chenhenry.java.concurrency.in.practice;


class Widget {
    public void doSomething() {
        synchronized (this) {
            System.out.println(this + ": Widget doSomething");
        }
    }
}

public class LoggingWidget extends Widget {
    @Override
    public void doSomething() {
        synchronized (this) {
            System.out.println(this + ": LoggingWidget doSomething");
            super.doSomething();
        }
    }

    public static void main(String[] args) {
        new LoggingWidget().doSomething();
    }
}
