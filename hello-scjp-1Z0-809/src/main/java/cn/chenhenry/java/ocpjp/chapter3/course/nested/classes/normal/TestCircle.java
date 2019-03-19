package cn.chenhenry.java.ocpjp.chapter3.course.nested.classes.normal;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(10, 10, 20);
        System.out.println(circle);

        Circle.Point point = circle.new Point(1, 1);
        System.out.println(point);
    }
}
