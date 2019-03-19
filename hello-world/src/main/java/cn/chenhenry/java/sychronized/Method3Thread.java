package cn.chenhenry.java.sychronized;

public class Method3Thread extends Thread {

    private Resource resource;

    public Method3Thread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.method3();
    }
}
