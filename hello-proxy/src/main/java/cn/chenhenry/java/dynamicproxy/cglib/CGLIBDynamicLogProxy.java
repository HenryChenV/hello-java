package cn.chenhenry.java.dynamicproxy.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @author henrychen
 * @date created at 2020/10/9 5:55 下午
 */


class LogInterceptor implements MethodInterceptor {

    /**
     * @param target 要增强的对象
     * @param method 要拦截的方法
     * @param args 参数列表，基本类型传入其包装类
     * @param methodProxy 对方法的代理，invokeSuper表示调用被代理对象的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("log before " + method.getName());

        Object ret = methodProxy.invokeSuper(target, args);

        System.out.println("log after " + method.getName());

        return ret;
    }
}

class LogInterceptor2 implements MethodInterceptor {

    /**
     * @param target 要增强的对象
     * @param method 要拦截的方法
     * @param args 参数列表，基本类型传入其包装类
     * @param methodProxy 对方法的代理，invokeSuper表示调用被代理对象的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("log2 before " + method.getName());

        Object ret = methodProxy.invokeSuper(target, args);

        System.out.println("log2 after " + method.getName());

        return ret;
    }
}

class LogCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if ("select".equals(method.getName())) {
            // 调用第0个
            return 0;
        }

        // 调用第1个
        return 1;
    }
}

public class CGLIBDynamicLogProxy {

    public static <T>  T getProxy(T target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new LogInterceptor());

        return (T) enhancer.create();
    }

    public static <T>  T getMutiCallbackProxy(T target) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(target.getClass());

        enhancer.setCallbacks(new Callback[] {new LogInterceptor(), new LogInterceptor2()});
        enhancer.setCallbackFilter(new LogCallbackFilter());

        return (T) enhancer.create();
    }

}
