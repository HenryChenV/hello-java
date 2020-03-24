package cn.chenhenry.java.equal;

public class IntEqualTest {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);
        System.out.println(c.equals(d));
    }
}
