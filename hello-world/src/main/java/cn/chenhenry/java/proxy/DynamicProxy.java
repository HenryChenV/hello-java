package cn.chenhenry.java.proxy;

import org.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class DynamicProxy {
}


interface IUserManager {
    void addUser(String id, String password);
}


class UserManagerImpl implements IUserManager {

    @Override
    public void addUser(String id, String password) {
        System.out.println("UserManagerImpl.addUser");
    }
}


class JDKProxy implements InvocationHandler {

    /**
     * 需要代理的对象
     */
    private Object targetObject;

    public Object newProxy(Object targetObject) {
        this.targetObject = targetObject;

        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomething();

        return method.invoke(targetObject, args);
    }

    private void doSomething() {
        System.out.println("JDKProxy.doSomething: 在代理中做点其他事情");
    }
}


class CGLibProxy implements MethodInterceptor {

    private Object targetObject;

    public Object createProxyObject(Object obj) {
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        if ("addUser".equals(method.getName())) {
            doSomething();
        }

        Object ret = null;
        System.out.println(methodProxy.getSignature().getDescriptor());
        // ret = methodProxy.invoke(targetObject, objects);
        // ret = methodProxy.invokeSuper(o, objects);
        ret = method.invoke(targetObject, objects);

        return ret;
    }

    private void doSomething() {
        System.out.println("CGLibProxy.doSomething: 在代理中做点其他事情");
    }
}


class Client {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        runJDKProxy();

        // runCGLibProxy();
    }

    private static void runJDKProxy() {
        System.out.println("===================== JDKProxy ======================");
        JDKProxy jdkProxy = new JDKProxy();
        IUserManager userManagerJDK = (IUserManager) jdkProxy.newProxy(new UserManagerImpl());
        userManagerJDK.addUser("henryJDK", "12345");
    }

    private static void runCGLibProxy() {
        System.out.println("===================== CGLibProxy ======================");
        System.setProperty(
                DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "/Users/henry/projects/henry/hello-java/hello-world/target/classes/"
        );
        CGLibProxy cgLibProxy = new CGLibProxy();
        UserManagerImpl userManagerCGLib = (UserManagerImpl) cgLibProxy.createProxyObject(new UserManagerImpl());
        userManagerCGLib.addUser("henryCGLib", "123456");
        System.out.println(userManagerCGLib.toString());
    }
}