package cn.chenhenry.java.sychronized;

public class Resource {

    public synchronized void method1() {
        System.out.println("method1 running");
        try {
            Thread.sleep(1000);
            System.out.println("method1 sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method1 end");
    }

    public synchronized void method2() {
        System.out.println("method2 running");
        try {
            Thread.sleep(1000);
            System.out.println("method2 sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method2 end");
    }

    public static synchronized void method3() {
        System.out.println("method3 running");
        try {
            Thread.sleep(1000);
            System.out.println("method3 sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method3 end");
    }

    public static synchronized void method4() {
        System.out.println("method4 running");
        try {
            Thread.sleep(1000);
            System.out.println("method4 sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method4 end");
    }

}
