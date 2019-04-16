package cn.chenhenry.java;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        listAll(1, 2, 3, 4);
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
