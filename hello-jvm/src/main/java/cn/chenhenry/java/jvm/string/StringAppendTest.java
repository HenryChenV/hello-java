package cn.chenhenry.java.jvm.string;

import com.sun.tools.corba.se.idl.StringGen;

/**
 * @author henrychen
 * @date created at 2020/8/30 6:03 下午
 */
public class StringAppendTest {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
    }

    public static void test1() {
        String s1 = "1";   // String+1, char[]+1
        String s2 = "1";   // String+0, char[]+0
        String s3 = "11";  // String+1, char[]+1

        String s = s1 + s2;  // String+1, char[]+1
    }

    public static void test2() {
        String s1 = "2";  // String+1, char[]+1
        String s2 = new String("2");  // String+1, char[]+0
        String s3 = "22";  // String+1, char[]+1

        String s = s1 + s2;  // String+1, char[]+1
    }

    public static void test3() {
        final String s1 = "3";
        final String s2 = "3";
        String s3 = "33";

        String s = s1 + s2;

        System.out.println(s == s3);
    }

    public static void test4() {
        String s1 = "41";
        String s2 = new String("42");

        String s = s1 + s2;
    }

    public static void test5() {
        String s = "51" + new String("52");  // String+4, char[]+3
    }

    public static void test6() {
        String s1 = "61" + "62";  // 编译时会计算，不会做加的运算String+1, char[]+1
        String s = "61" + new String("62");  // String+4, char[]+3
    }
}
