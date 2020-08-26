package cn.chenhenry.java.bytecode.method.call;

import com.sun.prism.shader.DrawCircle_LinearGradient_PAD_AlphaTest_Loader;

/**
 * @author henrychen
 * @date created at 2020/8/26 10:55 上午
 */
public class MultiDispatch {

    static class Cigarette {}
    static class Toy {}

    static class Parent {

        public void choice(Cigarette cigarette) {
            System.out.println("parent choice cigarette");
        }

        public void choice(Toy toy) {
            System.out.println("parent choice toy");
        }
    }

    static class Child extends Parent {

        @Override
        public void choice(Cigarette cigarette) {
            System.out.println("child choice cigarette");
        }

        @Override
        public void choice(Toy toy) {
            System.out.println("child choice toy");
        }
    }

    public static void main(String[] args) {
        Toy toy = new Toy();
        Parent parent = new Parent();
        Parent child = new Child();

        parent.choice(toy);
        child.choice(toy);
    }

}
