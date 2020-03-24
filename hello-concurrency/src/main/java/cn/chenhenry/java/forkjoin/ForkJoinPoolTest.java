package cn.chenhenry.java.forkjoin;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class ForkJoinPoolTest {
    @Test
    public void testCalWorkQueueLength() {
        for (int i = 0; i < 100; i++) {
            System.out.println("i="+i+",result="+calWorkQueueLength(i));
        }
    }

    /**
     * 计算workQueues长度
     * @param p 并行数
     * @return
     */
    private int calWorkQueueLength(int p) {
        int n = (p > 1) ? p - 1 : 1;
        n |= n >>> 1; n |= n >>> 2;  n |= n >>> 4;
        n |= n >>> 8; n |= n >>> 16; n = (n + 1) << 1;
        return n;
    }

    @Test
    public void testAdvanceProbe() {
        // int probe = 0x9e3779b9;
        int probe = 1;
        System.out.println(probe);
        for (int i = 0; i < 10; i++) {
            System.out.println(doAdvanceProbe(probe));
        }
    }

    @Test
    public void testScanRecomputeR() {
        int r = 2;
        for (int i = 0; i < 10; i++) {
            System.out.println((r = doScanRecomputeR(r)));
        }
    }

    private int doScanRecomputeR(int r) {
        r ^= r << 1; r ^= r >>> 3; r ^= r << 10;
        return r;
    }

    public int doAdvanceProbe(int probe) {
        probe ^= probe << 13;   // xorshift
        probe ^= probe >>> 17;
        probe ^= probe << 5;
        return probe;
    }

    @Test
    public void testIntegerNumberOfLeadingZeros() {
        for (int i = 0; i < 65; i++) {
            System.out.println("i="+i+",numberOfLeadingZeros="+Integer.numberOfLeadingZeros(0));
        }
    }
}
