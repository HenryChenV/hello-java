package cn.chenhenry.java.clinit;

import java.sql.DriverManager;

/**
 * @author henrychen
 * @date created at 2020/8/22 7:06 下午
 */
public class ConstantPoolCacheTest {
    public static void main(String[] args) {
        System.out.println(ChildInConstantPoolCacheTest.str);

        while (true);
    }
}

class ParentInConstantPoolCacheTest {
    public static String str = "str x";
    static {
        System.out.println("static block in class Parent");
    }
}

class ChildInConstantPoolCacheTest extends ParentInConstantPoolCacheTest {
    static {
        System.out.println("static block in class Child");
    }
}
