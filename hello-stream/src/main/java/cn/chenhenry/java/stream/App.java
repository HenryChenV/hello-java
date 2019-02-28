package cn.chenhenry.java.stream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        int size = new Random().nextInt(66) + 1;

        List<Integer> list1 = Lists.newArrayList();
        List<Integer> list2 = Lists.newArrayList();

        for (int i = 0; i < size; i++) {
            list1.add(i);
        }

        list1.parallelStream().forEach(list2::add);

        System.out.println(list1);
        System.out.println(list2);

    }
}
