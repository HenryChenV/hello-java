package cn.chenhenry.java.ocpjp.chapter11.course.atomic;

import org.omg.PortableServer.THREAD_POLICY_ID;
import sun.jvm.hotspot.debugger.win32.coff.DebugVC50SSPreComp;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    public static Integer integer = new Integer(0);
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
}

public class AtomicVariableTest {

    static final int THREAD_COUNT = 1000;

    static class Incrementr extends Thread {
        @Override
        public void run() {
            Counter.integer++;
            Counter.atomicInteger.incrementAndGet();
        }
    }

    static class Decrementer extends Thread {
        @Override
        public void run() {
            Counter.integer--;
            Counter.atomicInteger.decrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] incrementerThread = new Incrementr[THREAD_COUNT];
        Thread[] decrementerTHread = new Decrementer[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            incrementerThread[i] = new Incrementr();
            decrementerTHread[i] = new Decrementer();
            incrementerThread[i].start();
            decrementerTHread[i].start();
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            incrementerThread[i].join();
            decrementerTHread[i].join();
        }

        System.out.printf("Integer value = %d AtomicInteger value = %d ", Counter.integer, Counter.atomicInteger.get());
    }

}
