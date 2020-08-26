package cn.chenhenry.java.ocpjp.chapter5.course.buidin.functional.interfaces.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerTest {
    public static void main(String[] args) {
        BiConsumer<List<Integer>, Integer> listAddElement = List::add;
        List<Integer> aList = new ArrayList<>();
        listAddElement.accept(aList, 10);
        System.out.println(aList);
    }
}
