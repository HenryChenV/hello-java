package cn.chenhenry.java.jvm.bytecode.method.call;

/**
 * @author henrychen
 * @date created at 2020/8/26 8:33 上午
 */
public class StaticDispatch {

    static class Parent {}
    static class Child extends Parent{}

    public void call(Parent parent) {
        System.out.println("call parent");
    }

    public void call(Child child) {
        System.out.println("call child");
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        StaticDispatch dispatch = new StaticDispatch();
        dispatch.call(parent);
    }

}
