package cn.chenhenry.java.string;

/**
 * @author henrychen
 * @date created at 2020/8/30 6:03 下午
 */
public class StringAppendTest {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test1() {
        String s1 = "1";
        String s2 = "1";
        String s3 = "11";

        String s = s1 + s2;

        System.out.println(s == s3);
    }

    public static void test2() {
        String s1 = "2";
        String s2 = new String("2");
        String s3 = "22";

        String s = s1 + s2;
    }

    public static void test3() {
        final String s1 = "3";
        final String s2 = "3";
        String s3 = "33";

        String s = s1 + s2;

        System.out.println(s == s3);
    }

}
