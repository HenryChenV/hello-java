package cn.chenhenry.java.dynamicproxy.jdk;

import cn.chenhenry.java.target.UserServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author henrychen
 * @date created at 2020/10/9 5:32 下午
 */
public class JDKProxyUtil {

    public static void generateClassFile(Class targetClass, String proxyName) {
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, targetClass.getInterfaces());

        String path = targetClass.getResource(".").getPath();

        String name = path + proxyName + ".class";

        try (FileOutputStream out = new FileOutputStream(name)) {

            out.write(classFile);
            out.flush();

            System.out.println("^-^ done. " + name);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDKProxyUtil.generateClassFile(UserServiceImpl.class, "UserServiceJDKProxy");
    }

}
