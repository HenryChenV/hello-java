package cn.chenhenry.java.jvm.bytecode.method.call;

/**
 * @author henrychen
 * @date created at 2020/8/26 10:05 上午
 */
public class DynamicDispatch {

    static class Parent {
        public void call() {
            System.out.println("call parent");
        }
    }

    static class Child extends Parent {
        @Override
        public void call() {
            System.out.println("call child");
        }
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        parent.call();
    }

}
