package cn.chenhenry.java.classloader;

import com.sun.jdi.PathSearchingVirtualMachine;
import sun.misc.Launcher;

import java.net.URL;

/**
 * @author henrychen
 * @date created at 2020/8/23 9:12 下午
 */
public class BootClassLoaderPath {
    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }
    }
}
