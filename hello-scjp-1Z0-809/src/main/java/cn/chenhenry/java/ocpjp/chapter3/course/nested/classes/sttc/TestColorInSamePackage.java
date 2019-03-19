package cn.chenhenry.java.ocpjp.chapter3.course.nested.classes.sttc;

public class TestColorInSamePackage {
    public static void main(String[] args) {
        Shape.Color white = new Shape.Color(255, 255, 255);
        System.out.println("White color has values: " + white);
    }
}
