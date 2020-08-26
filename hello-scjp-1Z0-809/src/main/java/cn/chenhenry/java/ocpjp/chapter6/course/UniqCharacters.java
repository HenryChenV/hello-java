package cn.chenhenry.java.ocpjp.chapter6.course;

import java.util.Arrays;
import java.util.Optional;

public class UniqCharacters {
    public static void main(String[] args) {
        String[] words = "you never know what you have until you clean your room".split(" ");

        System.out.println("map: ");
        Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .forEach(word -> System.out.println(Arrays.asList(word)));

        System.out.println("flatMap: ");
        Arrays.stream(words)
                .flatMap(word -> Arrays.stream(word.split("")))
                .peek(item -> System.out.println("peek: " + item))
                .distinct()
                .forEach(item -> System.out.println("forEach: " + item));
    }
}
