package cn.chenhenry.hello.bytebuddy.method.delegation;


import net.bytebuddy.ByteBuddy;
import net.bytebuddy.matcher.ElementMatchers;

import java.util.function.Function;

/**
 * @author chenhanli
 * @date 2022/3/19 11:50 下午
 */
public class MethodDelegationDemo {
    public static class GreetingInterceptor {
        public String greet(Object argument) {
            // 会匹配到这个, 因为不指定泛型类型的Function等于Function<Object, Object>
            // 匹配是貌似只看了入参, 没关心返回值
            return "Greet from " + argument;
        }

        public String hello(String name) {
            return "Hello from " + name;
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<? extends Function> dynamicType = new ByteBuddy()
                .subclass(Function.class)
                .method(ElementMatchers.named("apply"))
                .intercept(net.bytebuddy.implementation.MethodDelegation.to(new GreetingInterceptor()))
                .make()
                .load(MethodDelegationDemo.class.getClassLoader())
                .getLoaded();

        System.out.println(dynamicType.newInstance().apply("CHL"));
    }
}
