package cn.chenhenry.java.jvm.clinit.simple;

/**
 * 静态代码快的clinit的执行顺序和代码定义顺序一致
 * @author henrychen
 * @date created at 2020/8/22 12:35 上午
 */

public class SimpleStaticClinitOrderTest {

    public static void main( String[] args ) {
        A a = A.getInstance();
        System.out.println(A.val1);
        System.out.println(A.val2);

        while (true);
    }

}

class A {

    public static int val1;

    public static A instance = new A();

    public static int val2 = 20;


    A() {
        System.out.println("in A() val1=" + val1 + ",val2=" + val2);
        val1++;
        val2++;
        System.out.println("in A() val1=" + val1 + ",val2=" + val2);
    }

    public static A getInstance() {
        return instance;
    }

}
