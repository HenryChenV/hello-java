package cn.chenhenry.java.memory.strategy;

/**
 * 为了避免大对象在Eden区以及两个Survivor区之间拷贝, 将大对象直接分配到老年代中
 *
 * 可以用PretenureSizeThreshold参数指定分配到老年代的对象大小的阈值,
 * 这个参数只对Serial和ParNew有效, Parallel Scavenge收集器不认这个参数
 *
 * VM Options:
 *      -XX:+UseSerialGC
 *      -XX:+PrintGCDetails
 *      -verbose:gc
 *      -Xms:20M
 *      -Xmx20M
 *      -Xmn10M
 *      -XX:SurvivorRatio=8
 *      -XX:PretenureSizeThreshold=3145728;
 */
public class AllocationInOldForBigObject {

    private static final int _1MB = 1024 * 1024;

    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
