package cn.chenhenry.java.ocpjp.chapter3.course.interfaces;

abstract class Shape {

    abstract double area();

    private Shape parentShape;

    public Shape getParentShape() {
        return parentShape;
    }

    public void setParentShape(Shape parentShape) {
        this.parentShape = parentShape;
    }
}


interface Rollable {
    
    int attribute = 0;
    
    void roll(float degree);
    static void hello() {
        
    };
}


abstract class CircularShape extends Shape implements Rollable {
    // The abstract class CircularShape implements the Rollable interface
    // but does not need to define the roll() method.
}


public class Circle extends CircularShape {
    private int xPos, yPos, radius;

    public Circle(int x, int y, int r) {
        xPos = x;
        yPos = y;
        radius = r;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void roll(float degree) {
        System.out.println(String.format("rolling circle by %f degrees", degree));
    }

    public static void main(String[] args) {
        Circle circle = new Circle(10, 10, 20);
        circle.roll(45);

        System.out.println(Circle.attribute);
    }
}
