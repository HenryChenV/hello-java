package com.chenhenry.example2;


import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author chenhanli
 * @date 2021/12/12 9:54 下午
 */
public class Server {
    public static void main(String[] args) {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        try {
            new InitialContext().lookup("rmi://127.0.0.1:1099/hello");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
