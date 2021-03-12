package cn.chenhenry.java;

import javax.xml.transform.sax.SAXTransformerFactory;

/**
 * @author henrychen
 * @date created at 2020/12/16 10:22 上午
 */
public class SynchronizedTest {

    private static final SynchronizedTest obj = new SynchronizedTest();

    public static synchronized void syncStaticMethod() {

    }

    public static void syncInStaticMethod() {
        synchronized (SynchronizedTest.class) {

        }
    }

    public synchronized void syncInstanceMethod() {

    }

    public void syncInInstanceMethod() {
        synchronized (obj) {

        }
    }

    public static void main(String[] args) {

    }

}
