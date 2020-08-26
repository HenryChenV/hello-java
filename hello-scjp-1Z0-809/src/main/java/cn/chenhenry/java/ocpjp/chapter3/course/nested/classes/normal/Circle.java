package cn.chenhenry.java.ocpjp.chapter3.course.nested.classes.normal;

public class Circle {

    public class Point {
        private int xPos;
        private int yPos;

        public Point(int x, int y) {
            xPos = x;
            yPos = y;
        }

        @Override
        public String toString() {
            return "(" + xPos + "," + yPos + ")";
        }
    }

    class SubPoint extends Point {

        public SubPoint(int x, int y) {
            super(x, y);
        }
    }

    private Point center;
    private int radius;

    public Circle(int x, int y, int r) {
        center = this.new Point(x, y);
        radius = r;
    }

    @Override
    public String toString() {
        return "mid point = " + center + " and radius = " + radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(10, 10, 20);
        System.out.println(circle);
    }
}
