package cn.chenhenry.java.ocpjp.chapter2.exam.question6;

public class Test {

    public void print(Integer i) {
        System.out.println("Integer");
    }

    public void print(int i) {
        System.out.println("int");
    }

    public void print(long i) {
        System.out.println("long");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.print(10);
        test.print(10L);
        test.print(new Integer(10));
    }

}
