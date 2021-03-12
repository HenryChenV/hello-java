package ignore.exception;

/**
 * @author henrychen
 * @date created at 2020/11/6 11:19 上午
 */
public class ExceptionUtils {

    @FunctionalInterface
    public static interface RunnableWithException {
        /**
         * 执行方法
         * @throws Exception
         */
        void run() throws Exception;
    }

    public static void ignoreAllException(RunnableWithException method) {
        try {
            method.run();
        } catch (Throwable e) {
            System.out.println(String.format("Exception[%s] in Method[%s] ignored", e, method));
        }
    }

}
