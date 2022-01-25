package com.chenhenry.example1;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author chenhanli
 * @date 2021/12/12 8:41 下午
 */
public class RemoteServiceImpl extends UnicastRemoteObject implements RemoteService {

    static {
        System.out.println("哈哈哈");
    }

    protected RemoteServiceImpl() throws RemoteException {
    }

    @Override
    public String hello() throws RemoteException {
        System.out.println("execute in " + this.getClass().getSimpleName());
        return "hi";
    }
}
