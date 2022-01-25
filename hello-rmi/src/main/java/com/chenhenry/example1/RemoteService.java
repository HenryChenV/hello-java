package com.chenhenry.example1;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author chenhanli
 * @date 2021/12/12 8:39 下午
 */
public interface RemoteService extends Remote {

    String hello() throws RemoteException;

}
