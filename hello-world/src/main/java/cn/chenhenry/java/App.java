package cn.chenhenry.java;

import org.junit.Test;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

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
}
