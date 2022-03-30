package cn.chenhenry.hello.bytebuddy.hello.world;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author chenhanli
 * @date 2022/3/19 8:56 下午
 */
public class HelloByteBuddy {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello ByteBuddy"))
                .make()
                .load(HelloByteBuddy.class.getClassLoader())
                .getLoaded();

        System.out.println(dynamicType.newInstance().toString());
    }
}
