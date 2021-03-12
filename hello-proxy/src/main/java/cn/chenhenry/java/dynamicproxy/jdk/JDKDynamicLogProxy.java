package cn.chenhenry.java.dynamicproxy.jdk;

import cn.chenhenry.java.target.IUserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author henrychen
 * @date created at 2020/10/9 5:16 下午
 */

class LogHandler implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("log before " + method.getName());

        Object ret = method.invoke(target, args);

        System.out.println("log after " + method.getName());

        return ret;
    }

}


public class JDKDynamicLogProxy {

    /**
     * @param target 代理对象
     */
    public static IUserService getProxy(IUserService target) {
        // 获取classLoader
        ClassLoader classLoader = target.getClass().getClassLoader();

        // 获取所有接口
        Class[] interfaces = target.getClass().getInterfaces();

        // 创建代理类请求处理器，处理所有代理对象上的方法调用
        InvocationHandler logHandler = new LogHandler(target);

        // 生成代理对象
        return (IUserService) Proxy.newProxyInstance(classLoader, interfaces, logHandler);
    }

}
