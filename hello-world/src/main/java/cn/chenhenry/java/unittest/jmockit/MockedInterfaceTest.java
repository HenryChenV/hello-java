package cn.chenhenry.java.unittest.jmockit;


import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author chenhanli
 * @date 2021/4/7 7:45 下午
 */
public class MockedInterfaceTest {

    @Mocked
    private IHello hello;

    @Test
    public void test1() {
        System.out.println(hello);
        System.out.println(hello.getInt());
        System.out.println(hello.say());
        System.out.println(hello.getHello());
    }

}
