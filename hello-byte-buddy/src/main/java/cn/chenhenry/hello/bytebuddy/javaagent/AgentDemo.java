package cn.chenhenry.hello.bytebuddy.javaagent;


import java.util.concurrent.Callable;

/**
 * @author chenhanli
 * @date 2022/3/20 10:15 下午
 */
public class AgentDemo implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("Success");
        return "Hello Byte Buddy Agent";
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public void print(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) throws Exception {
        AgentDemo agentDemo = new AgentDemo();
        agentDemo.call();
        agentDemo.hello("chl");
        agentDemo.print("1111");
    }
}
