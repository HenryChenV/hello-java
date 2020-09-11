package cn.chenhenry.java.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区 OOM
 * @author henrychen
 * @date created at 2020/9/10 10:54 上午
 */
public class MetaSpaceOOM {

    /**
     * 通过cglib模拟向元空间写入
     *
     * JVM Options:
     *      -XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=20m -XX:+PrintGCDetails -XX:+UseParallelGC -XX:+UseParallelOldGC
     * @param args
     */
    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Enhancer enhancer = new Enhancer();

            enhancer.setSuperclass(MetaSpaceOOM.class);

            enhancer.setUseCache(false);

            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, args);
                }
            });

            System.out.println("running...");

            enhancer.create();
        }
    }

}
