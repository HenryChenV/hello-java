package cn.chenhenry.java.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

public class CompareAndSwapTest {
    static class Target {
        public int value = 10;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //通过反射获得Unsafe实例，仅BootstrapClassLoader加载的类
        //（$JAVA_HOME/lib目录下jar包包含的类，如java.util.concurrent.atomic.AtomicInteger）
        // 才能通过Unsafe.getUnsafe静态方法获取
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        // 获取Target实例域value
        Field valueField = Target.class.getDeclaredField("value");
        // 实例化Target
        Target t = new Target();
        System.out.println("原始value值:" + valueField.get(t));

        // 获取实例域在class文件里的偏移量
        final long valueOffset = unsafe.objectFieldOffset(valueField);

        // 第一次swap
        System.out.println("第一次swap(10,20)函数返回值:"
                + unsafe.compareAndSwapInt(t, valueOffset, 10, 20));
        System.out.println("滴翠次swap(10,20)后value值:" + valueField.get(t));
        System.out.println(t.value);

        // 第二次swap
        System.out.println("第一次swap(10,20)函数返回值:"
                + unsafe.compareAndSwapInt(t, valueOffset, 10, 20));
        System.out.println("滴翠次swap(10,20)后value值:" + valueField.get(t));
        System.out.println(t.value);

    }
}
