package cn.chenhenry.java.bytecode;

import java.text.SimpleDateFormat;

/**
 * @author henrychen
 * @date created at 2020/8/26 8:48 上午
 */
public class SimpleRun {

    private static int a = 1;

    public static void main(String[] args) {
        SimpleRun run = new SimpleRun();

        System.out.println(run.add());
    }

    public int add() {
        int a = 10;
        int b = 20;

        return a + b;
    }

}
