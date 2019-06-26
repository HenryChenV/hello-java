package cn.chenhenry.java.ocpjp.chapter4.course.generic;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public void inspect(List<Object> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }

        //这个操作在当前方法的上下文是合法的。
        list.add(1);
        list.add("hello");
        System.out.println(list);
    }

    @Test
    public void testInspect() {
        inspect(new ArrayList<>());
    }

    @Test
    public void test() {
        List<String> strs = new ArrayList<String>();

        //编译错误
        // inspect(strs);
    }

    @Test
    public void classEqual() {
        System.out.println(new ArrayList<Integer>().getClass() == new ArrayList<String>().getClass());
    }

    public void wildcard(List<?> list) {
        // 编译错误
        // list.add(1);
    }

    @Test
    public void testWildcard() {
        wildcard(new ArrayList<>());
    }
}

class MyString implements Comparable<String> {
    @Override
    public int compareTo(String str) {
        return 0;
    }
}