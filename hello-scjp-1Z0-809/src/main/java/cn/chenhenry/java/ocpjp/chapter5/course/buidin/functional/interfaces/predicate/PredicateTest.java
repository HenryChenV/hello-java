package cn.chenhenry.java.ocpjp.chapter5.course.buidin.functional.interfaces.predicate;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        BiConsumer<List<Integer>, Integer> listAddElement = List::add;
        Predicate<String> nullCheck = arg -> arg != null;
        Predicate<String> emptyCheck = arg -> arg.length() > 0;
        Predicate<String> nullAndEmptyCheck = nullCheck.and(emptyCheck);

        System.out.println(nullAndEmptyCheck.test("hello"));
        System.out.println(nullAndEmptyCheck.test(null));
    }
}
