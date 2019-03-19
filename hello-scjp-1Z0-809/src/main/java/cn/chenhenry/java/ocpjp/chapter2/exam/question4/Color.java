package cn.chenhenry.java.ocpjp.chapter2.exam.question4;

class Color {
    int red, green, blue;

    Color() {
        // Color(10, 10, 10);
        this(10, 10, 10);
    }

    Color(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;
    }

    void printColor() {
        System.out.println("red: " + red + " green: " + green + " blue: " +
                blue);
    }

    public static void main(String[] args) {
        Color color = new Color();
    }
}
