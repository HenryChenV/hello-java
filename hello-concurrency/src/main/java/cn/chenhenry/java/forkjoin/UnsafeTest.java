package cn.chenhenry.java.forkjoin;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class UnsafeTest {

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Test
    public void test() {
        Unsafe U = reflectGetUnsafe();
        Class<?> ak = ForkJoinTask[].class;
        int abase = U.arrayBaseOffset(ak);
        int scale = U.arrayIndexScale(ak);

        System.out.println(abase);
        System.out.println(scale);
    }
}
