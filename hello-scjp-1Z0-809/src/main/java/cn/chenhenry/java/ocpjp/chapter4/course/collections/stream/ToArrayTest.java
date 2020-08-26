package cn.chenhenry.java.ocpjp.chapter4.course.collections.stream;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ToArrayTest {
    public static void main(String[] args) {
        Object[] words = Pattern.compile(" ").splitAsStream("1 2 3 4 5").toArray();
        System.out.println(Arrays.stream(words).mapToInt(str -> Integer.valueOf((String) str)).sum());
    }
}
