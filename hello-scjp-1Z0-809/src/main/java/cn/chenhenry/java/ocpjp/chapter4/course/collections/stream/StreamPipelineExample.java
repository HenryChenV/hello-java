package cn.chenhenry.java.ocpjp.chapter4.course.collections.stream;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class StreamPipelineExample {

    public static void main(String[] args) {
        System.out.println("Stream version: ");
        Arrays.stream(Object.class.getMethods())
                .map(method -> method.getName())
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Separate statements version: ");
        Method[] objectMethods = Object.class.getMethods();
        Stream<Method> objectMethodStream = Arrays.stream(objectMethods);
        Stream<String> objectMethodNames = objectMethodStream.map(method -> method.getName());
        Stream<String> uniqueObjectMethodNames = objectMethodNames.distinct();
        uniqueObjectMethodNames.forEach(System.out::println);
        System.out.println();
    }

}
