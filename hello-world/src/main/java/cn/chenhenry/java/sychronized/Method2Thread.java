package cn.chenhenry.java.sychronized;

public class Method2Thread extends Thread {

    private Resource resource;

    public Method2Thread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.method2();
    }
}
