package com.chenhenry.example1;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author chenhanli
 * @date 2021/12/12 8:45 下午
 */
public class RemoteApp {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(9999);
            registry.bind("remoteService", new RemoteServiceImpl());
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
