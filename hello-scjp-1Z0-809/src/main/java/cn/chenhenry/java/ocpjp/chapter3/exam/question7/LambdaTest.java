package cn.chenhenry.java.ocpjp.chapter3.exam.question7;

interface DoNothing {
    default void doNothing() {
        System.out.println("doNothing");
    }
}

interface DontDoAnything extends DoNothing {
    @Override
    abstract void doNothing();
}

public class LambdaTest {
    public static void main(String[] args) {
        DontDoAnything beIdle = () -> System.out.println("be idle");
        beIdle.doNothing();
    }
}
