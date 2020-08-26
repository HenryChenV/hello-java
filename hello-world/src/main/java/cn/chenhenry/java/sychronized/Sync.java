package cn.chenhenry.java.sychronized;

public class Sync {

    private Resource resource1 = new Resource();
    private Resource resource2 = new Resource();

    /**
     * synchronized
     */
    Thread r1m1Thread = new Method1Thread(resource1);
    /**
     * synchronized
     */
    Thread r1m2Thread = new Method2Thread(resource1);
    /**
     * static synchronized
     */
    Thread r1m3Thread = new Method3Thread(resource1);
    /**
     * static synchronized
     */
    Thread r1m4Thread = new Method4Thread(resource1);
    /**
     * synchronized
     */
    Thread r2m2Thread = new Method2Thread(resource2);
    /**
     * static synchronized
     */
    Thread r2m4Thread = new Method4Thread(resource2);

}
