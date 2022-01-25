package cn.chenhenry.java;


/**
 * @author chenhanli
 * @date 2022/1/12 11:51 下午
 */
public class Math {
    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }
}
