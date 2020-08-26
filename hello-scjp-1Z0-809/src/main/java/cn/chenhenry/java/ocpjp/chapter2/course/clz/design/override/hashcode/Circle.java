package cn.chenhenry.java.ocpjp.chapter2.course.clz.design.override.hashcode;

import java.util.HashSet;
import java.util.Set;

public class Circle {

    private int xPos, yPos, radius;

    public Circle(int x, int y, int r) {
        xPos = x;
        yPos = y;
        radius = r;
    }

    @Override
    public boolean equals(Object arg) {
        if (arg == null) {
            return false;
        }

        if (this == arg) {
            return true;
        }

        if (!(arg instanceof Circle)) {
            return false;
        }

        Circle that = (Circle) arg;

        return this.xPos == that.xPos && this.yPos == that.yPos && this.radius == that.radius;
    }

    @Override
    public int hashCode() {
        // use bit-manipulation operators such as ^ to generate close to unique hash code
        // here we are using magic numbers 7, 11, 53,
        // but you can use any numbers, preferably primes
        return (7 * xPos) ^ (11 * yPos) ^ (53 * radius);
    }

    public static void main(String[] args) {
        Set<Circle> circleSet = new HashSet<Circle>();
        circleSet.add(new Circle(10, 20, 5));

        // if not override hashCode, return false, otherwise return true
        System.out.println(circleSet.contains(new Circle(10, 20, 5)));
    }
}
