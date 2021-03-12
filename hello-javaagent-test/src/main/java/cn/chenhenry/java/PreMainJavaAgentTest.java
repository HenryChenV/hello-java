package cn.chenhenry.java;

import java.util.Date;

/**
 * @author henrychen
 * @date created at 2020/9/11 10:43 上午
 */
public class PreMainJavaAgentTest {

    /**
     * javaagent位置
     * -javaagent:./hello-javaagent/target/hello-javaagent-1.0-SNAPSHOT.jar
     *
     * 因为premain的类如果没有特殊指定，都是从启动类加载器加载的
     * 通过输出可以看到，用应用类加载器加载的都是intellij的类，也就是当前IDE
     * 而javassist没法通过启动类加载器加载，所以得把它放到启动类加载器路径上去
     * -Xbootclasspath/p:/Users/henry/.m2/repository/org/javassist/javassist/3.25.0-GA/javassist-3.25.0-GA.jar
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("PreMainJavaAgentTest main start");

        System.out.println("main " + new Date().toString());

        System.out.println("PreMainJavaAgentTest main end");
    }

}
