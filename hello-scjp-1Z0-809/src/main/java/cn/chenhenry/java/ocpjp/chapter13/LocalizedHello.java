package cn.chenhenry.java.ocpjp.chapter13;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedHello {
    public static void main(String[] args) throws MalformedURLException {
        File file = new File("hello-scjp-1Z0-809/src/main/java/cn/chenhenry/java/ocpjp/chapter13/properties/");
        URL[] urls = {file.toURI().toURL()};
        ClassLoader classLoader = new URLClassLoader(urls);

        Locale currentLocale = Locale.getDefault();

        ResourceBundle resBundle = ResourceBundle.getBundle(
                "ResourceBundle",
                currentLocale,
                classLoader
        );

        System.out.println(resBundle.getString("Greeting"));
    }
}
