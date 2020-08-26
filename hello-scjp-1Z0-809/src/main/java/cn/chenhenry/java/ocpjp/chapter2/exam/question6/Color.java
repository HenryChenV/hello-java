package cn.chenhenry.java.ocpjp.chapter2.exam.question6;

public class Color {

    int red, green, blud;

    Color() {
        this(10, 10, 10);
    }

    Color(int r, int g, int b) {
        red = r;
        green = g;
        blud = b;
    }

    @Override
    public String toString() {
        return "The Color is: " + red + green + blud;
    }

    public static void main(String[] args) {
        System.out.println(new Color());
    }
}
