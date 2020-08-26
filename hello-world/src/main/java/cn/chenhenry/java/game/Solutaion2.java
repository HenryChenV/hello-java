package cn.chenhenry.java.game;

import sun.tools.attach.HotSpotVirtualMachine;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solutaion2 {
    private int run(int n) {
        if (n < 2) {
            return n;
        }

        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            b += a;
            a = b - a;
        }

        System.out.println(b);
        return b;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(new Solutaion2().run(i));
        }
    }
}
