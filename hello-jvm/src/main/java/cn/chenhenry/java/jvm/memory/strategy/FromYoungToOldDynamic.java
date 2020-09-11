package cn.chenhenry.java.jvm.memory.strategy;

/**
 * 虚拟机并不总是要求对象年龄必须达到MaxTenuringThreshold才能晋升到老年代.
 * 如果Survivor空间中相同年龄所有对象总和大于Survivor空间的一半,
 *      年龄大于等于该年龄的对象就可以直接进入老年代, 无需等到MaxTenuringThreshold中要求的年龄
 *
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
 [GC (Allocation Failure) [DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 15)
- age   1:     870568 bytes,     870568 total
: 5615K->850K(9216K), 0.0090257 secs] 5615K->4946K(19456K), 0.0090661 secs] [Times: user=0.00 sys=0.01, real=0.01 secs]
[GC (Allocation Failure) [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
: 4946K->0K(9216K), 0.0017530 secs] 9042K->4935K(19456K), 0.0017821 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 def new generation   total 9216K, used 4178K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  eden space 8192K,  51% used [0x00000007bec00000, 0x00000007bf014930, 0x00000007bf400000)
  from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
  to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
 tenured generation   total 10240K, used 4935K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
   the space 10240K,  48% used [0x00000007bf600000, 0x00000007bfad1c98, 0x00000007bfad1e00, 0x00000007c0000000)
 Metaspace       used 2657K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
 *
 */
public class FromYoungToOldDynamic {
    private static final int _1MB = 1024 * 1024;

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];

        // allocation1 + allocation2等于survivor空间的一半

        allocation3 = new byte[4 * _1MB];
        // 触发GC, 不会有对象被回收, 对象总大小应该为4.5MB
        allocation4 = new byte[4 * _1MB];


        allocation4 = null;
        // 触发GC
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
