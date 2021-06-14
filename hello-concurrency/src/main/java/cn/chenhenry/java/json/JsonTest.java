package cn.chenhenry.java.json;


import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author chenhanli
 * @date 2021/3/26 5:06 下午
 */
public class JsonTest {

    public static class Operator {
        private Long id;
        private String name;

        public Operator(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Test
    public void tset() throws Exception{
        Operator raw = new Operator(1L, "henry");
        Object req = JSONObject.parseObject(JSONObject.toJSONString(raw), Object.class);
        System.out.println((Operator) req);
    }

}
