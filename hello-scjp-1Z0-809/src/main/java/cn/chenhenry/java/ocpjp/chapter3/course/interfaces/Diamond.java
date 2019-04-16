package cn.chenhenry.java.ocpjp.chapter3.course.interfaces;

interface Interface1 {
    default void foo() {
        System.out.println("Interface1's foo");
    }
}

interface Interface2 {
    default void foo() {
        System.out.println("Interface2's foo");
    }
}

public class Diamond implements Interface1, Interface2 {
    public static void main(String[] args) {
        new Diamond().foo();
    }

    @Override
    public void foo() {
        Interface1.super.foo();
    }
}
