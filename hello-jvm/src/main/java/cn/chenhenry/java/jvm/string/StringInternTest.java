package cn.chenhenry.java.jvm.string;

/**
 * @author henrychen
 * @date created at 2020/8/30 6:39 下午
 */
public class StringInternTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        String s1 = "1";
        String s2 = "1";

        String s = s1 + s2;

//        s.intern();

        String s3 = "11";

        System.out.println(s == s3);
    }

    public static void test2() {
        String s1 = "2";
        String s2 = "2";

        String s = s1 + s2;

        s.intern();

        String s3 = "22";

        System.out.println(s == s3);
    }
}
