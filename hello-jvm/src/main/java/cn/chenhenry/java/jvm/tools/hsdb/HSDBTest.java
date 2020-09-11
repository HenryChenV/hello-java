package cn.chenhenry.java.jvm.tools.hsdb;

/**
 * @author henrychen
 * @date created at 2020/9/9 11:55 上午
 */
public class HSDBTest {

    static class House {

        int id;

        House(int id) {
            this.id = id;
        }

    }

    static House staticObj = new House(111);

    House instanceObj = new House(2222);

    private int id;

    void foo() {
        House localObject = new House(3333);
        while (true);
    }

    public static void main(String[] args) {
        HSDBTest test = new HSDBTest();
        test.foo();
    }

}
