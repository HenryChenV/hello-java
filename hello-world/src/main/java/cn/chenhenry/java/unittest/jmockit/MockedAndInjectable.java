package cn.chenhenry.java.unittest.jmockit;


import mockit.Injectable;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.cglib.core.Local;

import java.util.Locale;

/**
 * @author chenhanli
 * @date 2021/4/7 7:54 下午
 */
public class MockedAndInjectable {

    @Test
    public void testMocked(@Mocked Locale locale) {
        Assert.assertNull(Locale.getDefault());
        Assert.assertNull(locale.getCountry());

        Assert.assertNull(new Locale("zh", "CN").getCountry());
    }

    @Test
    public void testInjectable(@Injectable Locale locale) {
        Assert.assertNotNull(Locale.getDefault());
        Assert.assertNull(locale.getCountry());

        Assert.assertNotNull(new Locale("zh", "CN").getCountry());
    }

}
