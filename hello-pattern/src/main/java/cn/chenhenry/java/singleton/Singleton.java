package cn.chenhenry.java.singleton;

/**
 * 单例模式
 */

public class Singleton {
}


/**
 * 饿汉模式
 */
class HungryModeSingleton {
    private static HungryModeSingleton instance = new HungryModeSingleton();

    /**
     * private构造器, 在外部直接用类初始化
     * 这样要拿到这个类的实例, 只能通过getInstance方法了
     */
    private HungryModeSingleton() {}

    public static HungryModeSingleton getInstance() {
        return instance;
    }
}


/**
 * 懒汉模式
 */
class LazyModeSingleton {
    private static LazyModeSingleton instance;

    private LazyModeSingleton() {}

    public static synchronized LazyModeSingleton getInstance() {
        if (instance == null) {
            return instance = new LazyModeSingleton();
        }

        return instance;
    }
}


/**
 * 双重检查
 *
 * 第一重检查在初始化后, 几乎所有请求都是false
 * 第二重检查是为了防止在多个线程中重复创建实例
 */
class DoubleCheckedLockingSingleton {
    private volatile static DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {}

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }

        return instance;
    }
}