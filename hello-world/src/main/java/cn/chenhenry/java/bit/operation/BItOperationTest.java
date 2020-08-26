package cn.chenhenry.java.bit.operation;

import org.junit.Test;

import javax.lang.model.type.PrimitiveType;

/**
 * 位运算
 */
public class BItOperationTest {

    @Test
    public void test() throws Exception {
        printBinaryNum("2 << 1", 2 << 1);
        // 100
        printBinaryNum("2 >> 1", 2 >> 1);
        // 1
        printBinaryNum("2 >>> 1", 2 >>> 1);
        // 1

        printBinaryNum("-1 >> 1", -1 >> 1);
        // 11111111111111111111111111111111
        printBinaryNum("-1 >>> 1", -1 >>> 1);
        // 1111111111111111111111111111111
    }

    private static void printBinaryNum(String expression, int num) {
        System.out.println(
                expression + ": " + Integer.toBinaryString(num));
    }
}
