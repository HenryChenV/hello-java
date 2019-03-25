package cn.chenhenry.java.ocpjp.chapter6.course;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SaveResultToACollection {}


class CollectorsToList {
    public static void main(String[] args) {
        String frenchCouting = "un:deux:trois:quatre";
        List<String> gmailList = Pattern.compile(":")
                .splitAsStream(frenchCouting)
                .collect(Collectors.toList());
        gmailList.forEach(System.out::println);
    }
}


class CollectorsToMap {
    public static void main(String[] args) {
        Map<String, Integer> nameLength = Stream.of("Arnold", "Alois", "Schwarzenegger")
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(nameLength);
    }
}


class CollectorsToTreeMap {
    public static void main(String[] args) {
        Map<String, Integer> nameLength = Stream.of("Arnold", "Alois", "Schwarzenegger")
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(nameLength);
    }
}


class GroupStringByLength {
    public static void main(String[] args) {
        String[] words = "you never know what you have until you clean your room".split(" ");

        Map<Integer, List<String>> wordGroups = Arrays.stream(words).distinct().collect(Collectors.groupingBy(String::length));
        System.out.println(wordGroups);

        Map<Boolean, List<String>> wordPartition =
                Arrays.stream(words).distinct()
                        .collect(Collectors.partitioningBy(word -> word.length() > 4));
        System.out.println(wordPartition);

        Map<Boolean, List<String>> wordPartition2 =
                Arrays.stream(words).distinct()
                        .collect(Collectors.partitioningBy(word -> word.length() > 4));
        System.out.println(wordPartition2);
    }
}
