package cn.chenhenry.java;

import cn.chenhenry.java.dynamicproxy.cglib.CGLIBDynamicLogProxy;
import cn.chenhenry.java.dynamicproxy.jdk.JDKDynamicLogProxy;
import cn.chenhenry.java.staticproxy.InheritedStaticLogProxy;
import cn.chenhenry.java.staticproxy.InterfaceStaticLogProxy;
import cn.chenhenry.java.target.IUserService;
import cn.chenhenry.java.target.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Hello world!
 *
 */
public class ProxyTest
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    private void testProxy(IUserService proxy) {
        System.out.println("start test proxy:" + proxy);

        proxy.select();
        proxy.update("conke");

        System.out.println("end");
    }

    @Test
    public void testTarget() {
        testProxy(new UserServiceImpl());
    }

    /**
     * 静态代理-基于继承
     * @throws Exception
     */
    @Test
    public void testInheritedStaticLogProxy() {
        testProxy(new InheritedStaticLogProxy());
    }

    /**
     * 静态代理-基于接口
     * @throws Exception
     */
    @Test
    public void testInterfaceStaticLogProxy() {
        testProxy(new InterfaceStaticLogProxy(new UserServiceImpl()));
    }

    /**
     * 动态代理-基于接口-jdk动态代理
     */
    @Test
    public void testJDKDynamicLogProxy() {
        IUserService proxy = JDKDynamicLogProxy.getProxy(new UserServiceImpl());

        testProxy(proxy);

        System.out.println(Proxy.isProxyClass(proxy.getClass()));
    }

    /**
     * 动态代理-基于继承-CGLIB动态代理
     */
    @Test
    public void testCGLIBDynamicLogProxy() {
        UserServiceImpl proxy = CGLIBDynamicLogProxy.getProxy(new UserServiceImpl());
        testProxy(proxy);
    }

    /**
     * 动态代理-基于继承-CGLIB动态代理-多个callback
     */
    @Test
    public void testCGLIBDynamicLogProxyMutiCallback() {
        UserServiceImpl proxy = CGLIBDynamicLogProxy.getMutiCallbackProxy(new UserServiceImpl());
        testProxy(proxy);
    }

    @Test
    public void test() throws Exception {
       int N = 100;
       int[] dp = new int[N + 1];
       dp[1] = 1;
       dp[0] = 0;
       dp[100] = 100;

       int result = Integer.MAX_VALUE;

       for (int i = 100; i <= 100; i++) {
           dp[i] = 1 + Math.max(i - 1, dp[N - i]);
           if (dp[i] < result) {
               result = dp[i];
           }
       }

        System.out.println(result);
    }
}
