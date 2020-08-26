package cn.chenhenry.java.ocpjp.chapter3.exam.question9;

import cn.chenhenry.java.ocpjp.chapter2.exam.question2.Base;

interface BaseInterface {
    default void foo() {
        System.out.println("BaseInterface's foo");
    }
}

interface DerivedInterface extends BaseInterface {
    @Override
    default void foo() {
        System.out.println("DerivedInterface's foo");
    }
}

interface AnotherInterface {
    public static void foo() {
        System.out.println("AnotherInterface's foo");
    }
}

public class MultipleInheritance implements DerivedInterface, AnotherInterface {
    public static void main(String[] args) {
        new MultipleInheritance().foo();
        // MultipleInheritance.foo(); // this is wrong
        AnotherInterface.foo();
    }
}
