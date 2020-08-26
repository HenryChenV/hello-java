package cn.chenhenry.java.ocpjp.chapter6.course;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortACollectionUsingStreamAPI {
}


class SortingCollection {
    public static void main(String[] args) {
        List words = Arrays.asList("follow your heart but take your brain with you".split(" "));
        words.stream().distinct().sorted().forEach(System.out::println);
    }
}


class SortByLength {
    public static void main(String[] args) {
        List words = Arrays.asList("follow your heart but take your brain with you".split(" "));
        Comparator<String> lengthCompatator = (str1, str2) -> str1.length() - str2.length();
        words.stream().distinct().sorted(lengthCompatator).forEach(System.out::println);
    }
}


class SortByLengthThenNatural {
    public static void main(String[] args) {
        List words = Arrays.asList("follow your heart but take your brain with you".split(" "));
        Comparator<String> lengthCompatator = (str1, str2) -> str1.length() - str2.length();
        words.stream().distinct().sorted(lengthCompatator.thenComparing(String::compareTo)).forEach(System.out::println);
    }
}


class SortByLengthThenNaturalReversed {
    public static void main(String[] args) {
        List words = Arrays.asList("follow your heart but take your brain with you".split(" "));
        Comparator<String> lengthCompatator = (str1, str2) -> str1.length() - str2.length();
        words.stream()
                .distinct()
                .sorted(lengthCompatator.thenComparing(String::compareTo).reversed())
                .forEach(System.out::println);
    }
}
