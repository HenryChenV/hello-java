package ignore.exception;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author henrychen
 * @date created at 2020/11/6 11:31 上午
 */
public class ExceptionUtilsTest {

    static class Hello {

        public void fuck() throws Exception {
            throw new Exception("请文明");
        }

    }

    @Test
    public void ignore() {

        ExceptionUtils.ignoreAllException(() -> {
            new Hello().fuck();
        });
    }
}