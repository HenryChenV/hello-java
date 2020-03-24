package cn.chenhenry.java.beanutils;

import lombok.Data;
import org.springframework.beans.BeanUtils;

enum E1 {
    VALUE1(1),
    VALUE2(2),
    ;

    private int val;

    private E1(int val) {
        this.val = val;
    }
}

enum E2 {
    VALUE1(1),
    VALUE2(2),
    ;

    private int val;

    E2(int val) {
        this.val = val;
    }
}

class B {
    E2 aEnum;
}

class A {
    E1 aEnum;
}

@Data
class Parent {
    private String name;
}

@Data
class Child extends Parent {
    private Long id;
}

public class BeanUtilsTest {
    public static void main(String[] args) {
        A a = new A();
        a.aEnum = E1.VALUE1;

        B b = new B();
        BeanUtils.copyProperties(a, b);
        System.out.println(a.aEnum);
        System.out.println(b.aEnum);

        System.out.println(E2.valueOf(E1.VALUE1.name()));

        Child c1 = new Child();
        c1.setId(1L);
        c1.setName("henry");
        Child c2 = new Child();
        BeanUtils.copyProperties(c1, c2);
        System.out.println(c2);
        System.out.println(c2.getName());
    }
}
