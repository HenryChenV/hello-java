package com.chenhenry.example2;


import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

/**
 * @author chenhanli
 * @date 2021/12/12 8:41 下午
 */
public class BadMan implements ObjectFactory {

    static {
        System.out.println("哈哈哈");
    }

    public BadMan() throws RemoteException {
    }

    public String hello() throws RemoteException {
        System.out.println("execute in " + this.getClass().getSimpleName());
        return "hi";
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return new BadMan();
    }
}
