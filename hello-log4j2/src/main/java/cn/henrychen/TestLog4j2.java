package cn.henrychen;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author chenhanli
 * @date 2021/12/11 3:20 下午
 */
public class TestLog4j2 {

    private static final Logger LOGGER = LogManager.getLogger(TestLog4j2.class);

    public static void main(String[] args) {
        String name = "chenhanli";
        LOGGER.info("hello, {}", name);
    }
}
