package cn.chenhenry.java.sychronized;

public class Method4Thread extends Thread {

    private Resource resource;

    public Method4Thread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.method4();
    }
}
