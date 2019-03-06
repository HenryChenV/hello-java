package cn.chenhenry.java.memory.strategy;

/**
 * jvm给每个对象一个年龄计数器,
 * 如果对象在eden出生病第一次Minor GC后仍然存活, 并且能被Survivor容纳, 将被移动到Survivor, 并将年龄设为1.
 * 对象在Survivor区中每熬过一次Minor GC, 年龄就增加1岁, 当年龄增加到阈值, 就会晋升到老年代中.
 * 晋升老年代的阈值, 可以通过参数: -XX:MaxTenuringThreshold 来设置
 *
 * VM Options:
 *      -XX:+UseSerialGC
 *      -XX:+PrintGCDetails
 *      -verbose:gc
 *      -Xms20M
 *      -Xmx20M
 *      -Xmn10M
 *      -XX:SurvivorRatio=8
 *      -XX:MaxTenuringThreshold=1
 *      -XX:+PrintTenuringDistribution
 *
 * Output:
 [GC (Allocation Failure) [DefNew
 Desired survivor size 524288 bytes, new threshold 1 (max 1)
 - age   1:     346184 bytes,     346184 total
 : 5104K->338K(9216K), 0.0078643 secs] 5104K->4434K(19456K), 0.0079569 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 [GC (Allocation Failure) [DefNew
 Desired survivor size 524288 bytes, new threshold 1 (max 1)
 : 4434K->0K(9216K), 0.0082235 secs] 8530K->8519K(19456K), 0.0082548 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 Heap
 def new generation   total 9216K, used 4178K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 eden space 8192K,  51% used [0x00000007bec00000, 0x00000007bf014930, 0x00000007bf400000)
 from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
 to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
 tenured generation   total 10240K, used 8519K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 the space 10240K,  83% used [0x00000007bf600000, 0x00000007bfe51ca8, 0x00000007bfe51e00, 0x00000007c0000000)
 Metaspace       used 2657K, capacity 4486K, committed 4864K, reserved 1056768K
 class space    used 287K, capacity 386K, committed 512K, reserved 1048576K

 * VM Options:
 *      -XX:+UseSerialGC
 *      -XX:+PrintGCDetails
 *      -verbose:gc
 *      -Xms20M
 *      -Xmx20M
 *      -Xmn10M
 *      -XX:SurvivorRatio=8
 *      -XX:MaxTenuringThreshold=15
 *      -XX:+PrintTenuringDistribution
 *
 * Output:
 [GC (Allocation Failure) [DefNew
 Desired survivor size 524288 bytes, new threshold 15 (max 15)
 - age   1:     346184 bytes,     346184 total
 : 5104K->338K(9216K), 0.0111078 secs] 5104K->4434K(19456K), 0.0111868 secs] [Times: user=0.01 sys=0.01, real=0.02 secs]
 [GC (Allocation Failure) [DefNew
 Desired survivor size 524288 bytes, new threshold 15 (max 15)
 - age   2:     334904 bytes,     334904 total
 : 4434K->327K(9216K), 0.0052096 secs] 8530K->8519K(19456K), 0.0052383 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 Heap
 def new generation   total 9216K, used 4669K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 eden space 8192K,  53% used [0x00000007bec00000, 0x00000007bf03d8a0, 0x00000007bf400000)
 from space 1024K,  31% used [0x00000007bf400000, 0x00000007bf451c38, 0x00000007bf500000)
 to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
 tenured generation   total 10240K, used 8192K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 the space 10240K,  80% used [0x00000007bf600000, 0x00000007bfe00020, 0x00000007bfe00200, 0x00000007c0000000)
 Metaspace       used 2657K, capacity 4486K, committed 4864K, reserved 1056768K
 class space    used 287K, capacity 386K, committed 512K, reserved 1048576K

 * @author henry
 */
public class FromYoungToOld {
    private static final int _1MB = 1024 * 1024;

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[4 * _1MB];
        // GC
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        // GC
        allocation3 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
