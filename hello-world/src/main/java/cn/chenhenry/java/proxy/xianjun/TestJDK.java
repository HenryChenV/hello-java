package cn.chenhenry.java.proxy.xianjun;

public class TestJDK {
    public static void main(String[] args) {

        HelloProxy helloProxy = new HelloProxy();

        HelloImpl helloImpl = new HelloImpl();

        Hello hello = (Hello) helloProxy.getObj(helloImpl);

        System.out.println(hello.hello());

    }
}
