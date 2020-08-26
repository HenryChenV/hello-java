package cn.chenhenry.java.reference;

import java.lang.ref.*;
import java.lang.reflect.Field;

public class HelloReference {
}

/**
 * 如果内存空间足够, gc就不会回收软引用, 等到内存不够了再回收.
 * 只要垃圾回收器没回收它, 该对象就可以被程序使用.
 * 软引用可用来实现内存敏感的告诉缓存.
 * 软引用可以和一个引用队列联合使用, 如果软引用所引用的对象被垃圾回收,
 * JAVA虚拟机就会把这个软引用加入到与之关联的引用队列中.
 */
class HelloSoftReference {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        SoftReference<Object> softRef = new SoftReference<Object>(obj, refQueue);

        System.out.println(softRef.get());
        // output: java.lang.Object@2503dbd3

        System.out.println(refQueue.poll());
        // output: null

        obj = null;

        // System.gc()告诉JVM这是一个执行GC的好时机，但具体执不执行由JVM决定（事实上这段代码一般都会执行GC)
        System.gc();

        System.out.println(softRef.get());
        // java.lang.Object@2503dbd3

        // Thread.sleep(200); 这是因为从对象被回收到JVM将引用加入refQueue队列，需要一定的时间。
        // 而且poll并不是一个阻塞方法，如果没有数据会返回null，所以我们选择等待一段时间, 给gc和放队列的操作提供充足的时间。
        Thread.sleep(200);

        System.out.println(refQueue.poll());
        // output: null
        System.out.println(softRef.get());
        // output: java.lang.Object@2503dbd3


        // 结论:
        //     gc完后上面的引用队列为空, 并且软引用关联引用能get到,
        //     说明内存足够, 所以软引用并没有被回收,
    }
}


/**
 * 在gc时, 如果发现对象只有弱引用, 不管当前内存空间是否足够, 都会回收内存.
 * 不过gc线程的优先级很低, 不一定很快发现那些只有弱引用的对象.
 * 弱引用可以和一个引用队列联合使用, 如果弱引用所引用的对象被垃圾回收,
 * JAVA虚拟机机会把这个弱引用加入到阈值关联的引用队列中.
 */
class HelloWeakReference {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        WeakReference<Object> weakRef = new WeakReference<Object>(obj, refQueue);

        System.out.println(weakRef.get());
        // output: java.lang.Object@2503dbd3

        System.out.println(refQueue.poll());
        // output: null

        // 清除强引用, 触发GC
        obj = null;
        System.gc();

        System.out.println(weakRef.get());
        // output: null

        // 给jvm足够的时间执行gc, 然后将弱引用放入队列
        Thread.sleep(200);

        System.out.println(refQueue.poll());
        // output: java.lang.ref.WeakReference@4b67cf4d

        System.out.println(refQueue.poll());
        // output: null

        System.out.println(refQueue.remove());
        // 注意:
        //     程序会停在这个地方
        //     因为poll是飞阻塞的, remove是阻塞的, 如果队列没哦一数据, 那么当前线程一直等待
        //     如果队列有数据, 那么remove和poll都会将第一个元素出队

        // 结论:
        //     可以看到, gc后, 弱引用被放到了引用队列, 弱引用对应强引用也成了null
        //     说明强引用被回收了, 弱引用也就没用了.
    }
}


/**
 * 虚引用主要用来跟踪对象被垃圾回收器回收的活动.
 * 虚引用和软引用弱引用的一个区别在于: 虚引用必须和引用队列联合使用(这个看下各自引用类的构造器就可以了).
 * 当垃圾回收器回收一个对象时, 如果发现它还有虚引用, 就会把这个虚引用加入到阈值关联的引用队列中.
 * 程序可以通过判断引用队列中是否已经加入了虚引用, 来了解被引用的对象是否将要被垃圾回收.
 * 如果发现某个虚引用被加入到引用队列, 就可以在所引用的对象内存被回收之前采取必要行动,
 * 等引用队列中处理完了, 才会被真正回收.
 * 由于Object.finalize方法的不安全, 低效, 常常使用虚引用完成对象回收前的资源释放工作.
 */
class HelloPhantomReference {
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        Object obj = new Object();

        System.out.println(obj);
        // output: java.lang.Object@2503dbd3

        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantom = new PhantomReference<>(obj, refQueue);

        System.out.println(phantom.get());
        // output: null, 这里永远是null, 方法里面硬编码的

        System.out.println(refQueue.poll());
        // output: null

        // 清除强引用, 触发gc
        obj = null;
        System.gc();

        System.out.println(phantom.get());
        // output: null

        printReferenceReferent(phantom);
        // output: java.lang.Object@2503dbd3

        // 给gc和把引用放到队列的操作充足的时间
        Thread.sleep(200);

        Reference ref = refQueue.poll();
        System.out.println(ref);
        // output: java.lang.ref.PhantomReference@2503dbd3

        System.out.println(ref == phantom);
        // output: true

        printReferenceReferent(phantom);
        // output: java.lang.ref.PhantomReference@2503dbd3

        ref.clear();
        printReferenceReferent(ref);
        // output: null

        // 结论:
        //     gc触发后, obj的内存并没有被释放, 可以在引用队列中访问到,
        //     直到最后调用了clear方法, 才会被释放, 在clear之前可以插入一些其他的回收操作
    }

    /**
     * 打印引用关联的强引用
     * @param reference
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static void printReferenceReferent(Reference reference) throws NoSuchFieldException, IllegalAccessException {
        Field referent = Reference.class.getDeclaredField("referent");
        referent.setAccessible(true);
        Object obj = referent.get(reference);
        System.out.println(obj);
    }
}
