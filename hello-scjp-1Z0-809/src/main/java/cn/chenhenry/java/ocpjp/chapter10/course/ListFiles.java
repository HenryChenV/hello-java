package cn.chenhenry.java.ocpjp.chapter10.course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        try (Stream<Path> entries = Files.list(Paths.get("."))) {
            entries.map(Path::toAbsolutePath).forEach(System.out::println);
        }

        System.out.println("----------------------------------");

        try (Stream<Path> entries = Files.walk(Paths.get("."))) {
            entries.map(Path::toAbsolutePath).forEach(System.out::println);
        }
    }
}
