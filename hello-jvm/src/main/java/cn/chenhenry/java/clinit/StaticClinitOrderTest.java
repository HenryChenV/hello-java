package cn.chenhenry.java.clinit;

/**
 * 静态代码快的clinit的执行顺序和代码定义顺序一致
 * @author henrychen
 * @date created at 2020/8/22 12:35 上午
 */

public class StaticClinitOrderTest {

    public static void main( String[] args ) {
        A a = A.getInstance();
        System.out.println(A.val1);
        System.out.println(A.val2);
        System.out.println(A.val3);
        System.out.println(A.val4);
    }

}

class XX {
    private int x;

    public XX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "XX(" + x + ")";
    }
}


class A {

    public static int val1;

    public static XX val3;

    public static A instance = new A();

    public static int val2 = 20;

    public static XX val4 = new XX(40);


    A() {
        System.out.println("in A() val1=" + val1 + ",val2=" + val2 + "val3=" + val3 + "val4=" + val4);
        val1 = 1;
        val2 = 2;
        val3 = new XX(3);
        val4 = new XX(4);
        System.out.println("in A() val1=" + val1 + ",val2=" + val2 + "val3=" + val3 + "val4=" + val4);
    }

    public static A getInstance() {
        return instance;
    }

}
