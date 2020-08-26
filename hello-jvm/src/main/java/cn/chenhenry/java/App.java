package cn.chenhenry.java;

import java.lang.reflect.Parameter;

/**
 * Hello world!
 *
 */
class Parent1 {

}
class Parent2<T> {

}

class Child extends Parent2<Integer> {

}

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Child child = new Child();
        System.out.println(child instanceof Parent2);
    }
}
