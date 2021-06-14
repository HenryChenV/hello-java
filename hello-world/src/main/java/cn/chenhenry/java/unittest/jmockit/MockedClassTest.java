package cn.chenhenry.java.unittest.jmockit;


import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * @author chenhanli
 * @date 2021/4/7 7:39 下午
 */
public class MockedClassTest {

    @Mocked
    private Locale locale;

    @Test
    public void test1() {
        Assert.assertFalse(null == locale);
        Assert.assertTrue(null == locale.getCountry());

        Locale chinaLocal = new Locale("zh", "CN");
        Assert.assertTrue(null == chinaLocal.getCountry());
    }

    @Test
    public void test2(@Mocked Locale locale) {
        Assert.assertFalse(null == locale);
        Assert.assertTrue(null == locale.getCountry());
        Assert.assertTrue(null == Locale.getDefault());

        Locale chinaLocal = new Locale("zh", "CN");
        Assert.assertTrue(null == chinaLocal.getCountry());
    }

}
