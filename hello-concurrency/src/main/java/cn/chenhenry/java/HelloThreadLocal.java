package cn.chenhenry.java;

import org.omg.CORBA.OBJ_ADAPTER;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class ClassA {
    public void doSth() {
        Thread currentThread = Thread.currentThread();
        System.out.println("current threadId in A: " + currentThread.getId());

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        threadLocal.set(11);

        try {
            Method method = threadLocal.getClass().getDeclaredMethod("getMap", Thread.class);
            method.setAccessible(true);
            Object map = method.invoke(threadLocal, currentThread);
            System.out.println("ThreadLocalMap in A: " + map);
            System.out.println(map);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class ClassB {
    public void doSth() {
        Thread currentThread = Thread.currentThread();
        System.out.println("current threadId in B: " + currentThread.getId());

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        threadLocal.set(22);
        threadLocal.get();

        try {
            Method method = threadLocal.getClass().getDeclaredMethod("getMap", Thread.class);
            method.setAccessible(true);
            Object map = method.invoke(threadLocal, currentThread);
            System.out.println("ThreadLocalMap in B: " + map);
            System.out.println(map);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        ClassA a = new ClassA();
        a.doSth();

        a = null;
        System.gc();

        // 等待gc完成
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ClassB b = new ClassB();
        b.doSth();
    }
}

public class HelloThreadLocal {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("create task");
        Task task = new Task();

        System.out.println("create threadpool");
        ExecutorService es = Executors.newSingleThreadExecutor();

        System.out.println("run task");
        es.submit(task);
        es.shutdown();
    }
}
