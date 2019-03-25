package cn.chenhenry.java.ocpjp.chapter6.course.optional.classes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class WordsCalculation {
    public static void main(String[] args) {
        String[] strings = "you never know what you have until you clean your room".split(" ");
        System.out.println(Arrays.stream(strings).min(String::compareTo).get());

        Comparator<String> lengthComparator = (str1, str2) -> str1.length() - str2.length();
        System.out.println(Arrays.stream(strings).min(lengthComparator).get());

        System.out.println(IntStream.of(1, 2, 3, 4, 5).summaryStatistics());
    }
}
