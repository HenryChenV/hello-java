package cn.chenhenry.java.ocpjp.chapter7.course;

public class AssertionExample {
    public static void main(String[] args) {
        int i = Integer.MIN_VALUE;

        if (i < 0) {
            i = -i;
        }

        System.out.println("the value is: " + i);
        RuntimeException runtimeException = new RuntimeException();
        assert (i >= 0) : "impossible: i is negative";
    }
}
