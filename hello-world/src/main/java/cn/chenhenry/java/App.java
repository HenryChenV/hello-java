package cn.chenhenry.java;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(Arrays.toString("1.2.3.4.5".split("\\.")));
        // System.out.println( "Hello World!" );
        // listAll(1, 2, 3, 4);
    }

    @Test
    public void test() {
        String desc = null;
        String remark = "xxxx";

        System.out.println(Optional.ofNullable(desc).orElse(""));
    }

    private static final void listAll(Integer... ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        System.out.println(Arrays.asList(ints));


        System.out.println(ints.getClass());
        System.out.println(ints);
    }

    @Test
    public void testToMap() {
        Stream.of(1, 2, 3).collect(Collectors.toMap(
                item -> item,
                item -> null  // 空指针
        ));

    }

    @Test
    public void testToString() {
        Map<Long, List<Long>> map = new HashMap<>();
        map.put(1L, Arrays.asList(3L, 4L, 5L));

        System.out.println(map.toString());
    }

}
