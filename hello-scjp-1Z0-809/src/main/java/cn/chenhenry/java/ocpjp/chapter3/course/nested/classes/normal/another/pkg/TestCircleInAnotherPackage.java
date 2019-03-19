package cn.chenhenry.java.ocpjp.chapter3.course.nested.classes.normal.another.pkg;

import cn.chenhenry.java.ocpjp.chapter3.course.nested.classes.normal.Circle;

public class TestCircleInAnotherPackage {
    public static void main(String[] args) {
        Circle circle = new Circle(10, 10, 20);
        System.out.println(circle);

        Circle.Point point = circle.new Point(1, 1);
        System.out.println(point);

        Circle c2 = new Circle(10, 10, 20) {
            @Override
            public String toString() {
                return "xxxxx " + super.toString();
            }
        };
        System.out.println(c2);

    }
}
