package cn.chenhenry.java.memory.gc;

/**
 * 证明JAVA的GC用的并不是引用计数
 *
 * 在下例中, objA和objB互相引用, 如果JAVA的GC使用了引用计数, 在System.gc()时应该无法被回收.
 *
 * VM Options: -verbose:gc -XX:+PrintGCDetails
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 这个对象的目的是在
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        // 构成循环引用
        objA.instance = objB;
        objB.instance = objA;

        // 虽然都为null了, 但是内部的instance依然引用着对方, 引用计数并不为0
        objA = null;
        objB = null;

        // 手动触发gc
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
