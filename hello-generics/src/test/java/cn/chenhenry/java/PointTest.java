package cn.chenhenry.java;


import org.junit.Test;


public class PointTest {

    @Test
    public void teetIntegerPoint() {
        Point<Integer> intPoint = new Point<>();
        intPoint.setX(new Integer(1));
        System.out.println(intPoint.getX().getClass());
        System.out.println(intPoint.getX());
    }

    @Test
    public void testFloatPoint() {
        Point<Float> floatPoint = new Point();
        floatPoint.setX(new Float(1.1));
        System.out.println(floatPoint.getX().getClass());
        System.out.println(floatPoint.getX());

    }

    @Test
    public void testDefaultPoint() {
        Point defaultPoint = new Point();
        defaultPoint.setX(new Float(1.1));
        System.out.println(defaultPoint.getX().getClass());
        System.out.println(defaultPoint.getX());

    }

}