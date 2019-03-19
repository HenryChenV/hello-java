package cn.chenhenry.java.sychronized;

public class Method1Thread extends Thread {

    private Resource resource;

    public Method1Thread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.method1();
    }
}
