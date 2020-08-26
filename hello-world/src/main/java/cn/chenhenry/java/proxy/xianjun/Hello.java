package cn.chenhenry.java.proxy.xianjun;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface Hello {
    String hello();
}


class HelloImpl implements Hello {

    @Override
    public String hello() {
        return "hello xianjun";
    }
}

class HelloProxy implements InvocationHandler {



    Object obj;

    public Object getObj(Object obj) {

        this.obj = obj;

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(), this);

    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before xianjun");

        Object res = method.invoke(obj, args);

        System.out.println("after xianjun ");

        return res;    }

}
