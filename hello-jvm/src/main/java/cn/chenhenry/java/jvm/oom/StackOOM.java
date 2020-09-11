package cn.chenhenry.java.jvm.oom;

/**
 * @author henrychen
 * @date created at 2020/9/10 4:23 下午
 */
public class StackOOM {

    private int count;

    private void foo() {
        count++;

//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        foo();
    }

    /**
     * -Xss160K
     * @param args
     */
    public static void main(String[] args) {
        StackOOM test = new StackOOM();

        try {
            test.foo();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("栈深度: " + test.count);
        }
    }

}
