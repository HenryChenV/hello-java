package cn.chenhenry.java.string;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @author henrychen
 * @date created at 2020/8/29 10:56 下午
 */
public class StringTest {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    public static void test1() {
        String s1 = "1";
    }

    public static void test2() {
        String s1 = "2";
        String s2 = "2";
    }

    public static void test3() {
        String s1 = new String("3");
    }

    public static void test4() {
        String s1 = new String("4");
        String s2 = new String("4");
    }

    public static void test5() {
        String s1 = "5";
        String s2 = new String("5");
    }

}
