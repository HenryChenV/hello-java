package cn.chenhenry.java.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;


/**
 * 用完需要被释放的资源
 */
class Resource {
    public void close() {
        System.out.println("release resource...");
    }
}

/**
 * 这是个大对象, 占了很多资源
 */
class LargeObject {
    private Resource resource;

    LargeObject(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }
}


/**
 * 用虚引用替代finalize回收资源
 */
public class LargeObjectFinalizer extends PhantomReference<LargeObject> {

    private Runnable closeMethod;

    /**
     * 父类同款构造器
     * @param referent
     * @param q
     */
    public LargeObjectFinalizer(LargeObject referent, ReferenceQueue<LargeObject> q) {
        super(referent, q);

        // 这里不能直接引用LargeObject对象, 这样就会在这里存在一个强引用, 永远无法被回收
        // 这里也可以保存资源对象的引用
        closeMethod = referent.getResource()::close;
    }

    /**
     * 释放资源
     */
    public void finalizeResources() {
        // 释放资源
        closeMethod.run();
    }

    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<LargeObject> referenceQueue = new ReferenceQueue<>();
        List<LargeObjectFinalizer> references = new ArrayList<>();

        List<LargeObject> largeObjects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LargeObject largeObject = new LargeObject(new Resource());
            largeObjects.add(largeObject);
            references.add(new LargeObjectFinalizer(largeObject, referenceQueue));
        }

        // 清楚对象, 触发gc
        largeObjects = null;
        System.gc();

        // 给gc和放对象进队列的操作一点时间, 实验证明不给也可以
        // Thread.sleep(200);

        // 判断虚引用是否都进引用队列了

        for (LargeObjectFinalizer reference : references) {
            System.out.println(reference.isEnqueued());
            // output: true
        }

        // 手动释放资源, 然后释放引用
        Reference<?> referenceFromQueue;
        while ((referenceFromQueue = referenceQueue.poll()) != null) {
            // 释放资源
            ((LargeObjectFinalizer)referenceFromQueue).finalizeResources();
            // output: clearing...

            // 清除引用
            referenceFromQueue.clear();
        }

        // 结论:
        //     先创建一批大对象, 给每个大对象包一个虚引用
        //     清除大对象, 触发gc, 让虚引用进引用队列
        //     释放资源, 清除引用
    }
}
