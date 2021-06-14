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
        Integer raw = new Integer(0);
        Object obj = (Object) raw;
        Integer num = (Integer) obj;
        System.out.println(num);
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

    @Test
    public void testNullAble() {
        System.out.println(Optional.ofNullable(null).orElse(1));
        System.out.println(Optional.ofNullable(2).orElse(1));
    }

    @Test
    public void testSwitch1() {
        Collectors.toMap(null, null, null);
        String a = null;
        switch (a) {
            case "bbbbb":
                System.out.println("bbbbb");
                break;
            case "aaaaa":
                System.out.println("aaaaa");
                break;
            default:
                System.out.println("default");
        }
    }

    @Test
    public void testSwitch2() {
        Collectors.toMap(null, null, null);
        Integer a = null;
        switch (a) {
            case 1:
                System.out.println(1);
                break;
            default:
                System.out.println("default");
        }
    }

}
