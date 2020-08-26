package cn.chenhenry.java.memory.strategy;

/**
 * 对象优先分配在Eden区
 *
 * VM Options:
 *      -XX:+UseSerialGC
 *      -XX:+PrintGCDetails
 *      -verbose:gc
 *      -Xms20M
 *      -Xmx20M
 *      -Xmn10M
 *      -XX:SurvivorRatio=8
 * 运行后并没有出现期待的垃圾回收, 但是确实可以看出来对象确实优先分配到了Eden区
 *
 [GC (Allocation Failure) [DefNew: 7151K->338K(9216K), 0.0076998 secs] 7151K->6482K(19456K), 0.0077403 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 Heap
 def new generation   total 9216K, used 4516K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  eden space 8192K,  51% used [0x00000007bec00000, 0x00000007bf014930, 0x00000007bf400000)
  from space 1024K,  33% used [0x00000007bf500000, 0x00000007bf554850, 0x00000007bf600000)
  to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
 tenured generation   total 10240K, used 6144K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
  the space 10240K,  60% used [0x00000007bf600000, 0x00000007bfc00030, 0x00000007bfc00200, 0x00000007c0000000)
 Metaspace       used 2657K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
 *
 * @author henry
 */
public class AllocationInEden {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        // 触发GC
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }

}
