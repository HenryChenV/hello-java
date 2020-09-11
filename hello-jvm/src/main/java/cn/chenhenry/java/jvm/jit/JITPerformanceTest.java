package cn.chenhenry.java.jvm.jit;

import java.util.Random;

/**
 * JIT性能测试
 * @author henrychen
 * @date created at 2020/8/31 9:44 下午
 */
public class JITPerformanceTest {

    private static Random random = new Random();

    /**
     * VM Options:
     *     -Xint -XX:+PrintCompilation
     * Output:
     *     time cost: 37792
     *
     *
     * VM Options:
     *     -Xcomp -XX:+PrintCompilation
     * Output:
     *
     *
     * VM Options:
     *     -Xmixed -XX:+PrintCompilation
     * Output:
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count = 0;

        for (int i = 0; i < 99999999; i++) {
            count += plus();
        }

        System.out.println("time cost: " + (System.currentTimeMillis() - start));
    }

    private static int plus() {
        return random.nextInt(10);
    }


}
