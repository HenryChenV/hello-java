package cn.chenhenry.hello.bytebuddy.method.delegation;


import jdk.nashorn.internal.codegen.CompilerConstants;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author chenhanli
 * @date 2022/3/20 10:54 下午
 */
public class GeneralInterceptorDemo {

    public static class ToStringInterceptor {
        public static String intercept(@Origin Method method, @SuperCall Callable<?> callable) {
            return "Hello World from " + method + " in " + callable;
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(MethodDelegation.to(ToStringInterceptor.class))
                .make()
                .load(GeneralInterceptorDemo.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();
        System.out.println(dynamicType.newInstance().toString());
    }

}
