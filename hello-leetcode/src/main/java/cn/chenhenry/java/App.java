package cn.chenhenry.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        StringBuffer sb = new StringBuffer("abc");
        sb.replace(1, 2, "z");
        LinkedList<String> q = new LinkedList<>();
        q.add("a");
        System.out.println(sb);
    }
}
