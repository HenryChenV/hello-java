package cn.chenhenry.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author chenhanli
 * @date 2022/2/23 3:14 下午
 */
public class MyService {

    @Log
    public int foo(int value) {
        System.out.println("foo: " + value);
        return value + 1;
    }

    public int bar(int value) {
        System.out.println("bar: " + value);
        return value - 1;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        MyService myService = new ByteBuddy()
                // 动态生成MyService的子类
                .subclass(MyService.class)
                // 拦截方法
                .method(ElementMatchers.any())
                // 拦截器
                .intercept(Advice.to(LoggerAdvisor.class))
                .make()
                .load(MyService.class.getClassLoader())
                // 获取到Class对象
                .getLoaded()
                .newInstance();

        myService.foo(123);
        myService.bar(456);

    }

}
