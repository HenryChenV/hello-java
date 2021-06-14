package cn.chenhenry.utils.str;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


/**
 * @auther chenhanli
 * @date 2021/3/24 8:53 下午
 */
public class PlaceHolderUtilTest {

    @Test
    public void test() {
        String tmpl = "${date} is ${status}.";
        Map<String, String> values = new HashMap<>();
        values.put("date", "today");
        values.put("status", null);
        System.out.println(PlaceHolderUtil.replaceWithMap(tmpl, values));
    }

}