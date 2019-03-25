package cn.chenhenry.java.ocpjp.chapter5.course.buidin.functional.interfaces.function;

import java.util.Arrays;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> parseInt = Integer::parseInt;
        Function<Integer, Integer> absInt = Math::abs;
        Function<String, Integer> parseAndAbsInt = parseInt.andThen(absInt);

        Arrays.stream("4, -9, 16".split(", "))
                .map(Function.identity())
                .peek(item -> System.out.println("peek: " + item))
                .forEach(item -> System.out.println("forEach: " + item));

        Arrays.stream("4, -9, 16".split(", "))
                .map(parseAndAbsInt)
                .forEach(System.out::println);
    }
}
