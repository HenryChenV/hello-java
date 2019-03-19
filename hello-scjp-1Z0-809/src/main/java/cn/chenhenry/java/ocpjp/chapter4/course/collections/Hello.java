package cn.chenhenry.java.ocpjp.chapter4.course.collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Hello {
    public static void main(String[] args) {
        List<Integer> all = Arrays.asList(1, 2, 4, 3, 4);
        System.out.println(all.containsAll(Arrays.asList(1,2, 3)));
        System.out.println(all.containsAll(Arrays.asList(3, 4, 5)));
        System.out.println(all.containsAll(Arrays.asList(5, 6, 7)));

        System.out.println(all);
    }
}
