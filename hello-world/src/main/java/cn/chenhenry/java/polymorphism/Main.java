package cn.chenhenry.java.polymorphism;

import javafx.scene.CacheHint;

public class Main {
    public static void main(String[] args) {
        Parent child1 = new Child();
        Child child2 = new Child();

        child1.hello();
        child2.hello();
    }
}
