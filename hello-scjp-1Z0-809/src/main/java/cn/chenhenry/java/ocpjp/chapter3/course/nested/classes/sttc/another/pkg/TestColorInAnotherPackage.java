package cn.chenhenry.java.ocpjp.chapter3.course.nested.classes.sttc.another.pkg;

import cn.chenhenry.java.ocpjp.chapter3.course.nested.classes.sttc.Shape;

public class TestColorInAnotherPackage {
    public static void main(String[] args) {
        Shape.Color white = new Shape.Color(255, 255, 255);
        System.out.println("White color has values: " + white);
    }
}
