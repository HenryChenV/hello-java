package cn.chenhenry.java.jvm.bytecode;

/**
 * @author henrychen
 * @date created at 2020/8/26 8:29 上午
 */
public class FinalMethodTest {

    public final void hello() {

    }

    public static void main(String[] args) {
        FinalMethodTest finalMethodTest = new FinalMethodTest();

        //  invokevirtual #4 <cn/chenhenry/java/bytecode/FinalMethodTest.hello>
        finalMethodTest.hello();
    }

}
