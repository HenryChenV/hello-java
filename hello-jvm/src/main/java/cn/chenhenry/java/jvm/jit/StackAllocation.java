package cn.chenhenry.java.jvm.jit;

/**
 * 栈上分配
 * @author henrychen
 * @date created at 2020/8/31 10:52 下午
 */
class StackAllocationTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // 分配100w个对象
        for (int i = 0; i < 1000000; i++) {
            allocate();
        }

        System.out.println("time cost: " + (System.currentTimeMillis() - start));

        while (true);
    }

    private static void allocate() {
        StackAllocationTest obj = new StackAllocationTest();
    }

}
