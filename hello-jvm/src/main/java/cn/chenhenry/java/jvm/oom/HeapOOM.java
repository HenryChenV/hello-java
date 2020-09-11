package cn.chenhenry.java.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆区OOM
 * @author henrychen
 * @date created at 2020/9/10 4:00 下午
 */
public class HeapOOM {

    private int[] arr = new int[10];

    /**
     * -Xmn10m -Xmx10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
     * @param args
     */
    public static void main(String[] args) {
        List<HeapOOM> objs = new ArrayList<>();

        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            objs.add(new HeapOOM());
        }
    }

}
