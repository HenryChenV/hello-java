package cn.chenhenry.java.jvm.string;

/**
 * @author henrychen
 * @date created at 2020/8/30 1:36 下午
 */
public class StringConstructorTest {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        String s1 = new String(new char[]{'1', '1'});
        String s2 = "11";
        String s3 = new String("11");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
    }

}
