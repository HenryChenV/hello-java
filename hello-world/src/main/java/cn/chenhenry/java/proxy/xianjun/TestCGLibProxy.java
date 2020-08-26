package cn.chenhenry.java.proxy.xianjun;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCGLibProxy implements MethodInterceptor {

    private Object target;

    public Object newInstance(Object source){

        target = source;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());

        enhancer.setCallback(this);

        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before method!!!");

        Object value = null;
        System.out.println(o);
        value = methodProxy.invokeSuper(o, objects);
        // value = methodProxy.invoke(o, objects);
        // value = method.invoke(o, objects);

        return value;

    }

    public static void main(String[] args) {

        TestCGLib instance = (TestCGLib) new TestCGLibProxy().newInstance(new TestCGLib());

        instance.hello("xianjun");
    }

}