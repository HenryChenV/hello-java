package cn.chenhenry.java.ocpjp.chapter6.course.optional.classes;

import java.util.IntSummaryStatistics;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class WordsStatistics {
    public static void main(String[] args) {
        String limerick = "There was a young lady named Bright " +
                "who traveled much faster than light " +
                "She set out one day " +
                "in a relative way " +
                "and came back the previous night ";

        IntSummaryStatistics wordsStatistics =
                Pattern.compile(" ")
                .splitAsStream(limerick)
                .mapToInt(String::length)
                .summaryStatistics();

        System.out.println(wordsStatistics);

        System.out.println(IntStream.of(10, 20, 30, 40).reduce(0, (val1, val2) -> (val1 + val2)));
    }
}
