package com.chenhenry.example1;


import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author chenhanli
 * @date 2021/12/12 8:51 下午
 */
public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(9999);
            Remote remoteService = registry.lookup("remoteService");
            System.out.println(((RemoteService) remoteService).hello());
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
