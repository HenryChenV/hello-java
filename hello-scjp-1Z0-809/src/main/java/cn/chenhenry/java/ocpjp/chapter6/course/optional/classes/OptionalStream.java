package cn.chenhenry.java.ocpjp.chapter6.course.optional.classes;

import java.util.Optional;

public class OptionalStream {
    public static void main(String[] args) {
        Optional<String> string = Optional.of("    afdsfdsfds ");
        string.map(String::trim).ifPresent(s -> System.out.println("ifPresent: " + s));

        System.out.println("orElse: " + string.map(String::length).orElse(-1));

        string = Optional.empty();
        System.out.println("orElseThrow: " + string.map(String::length).orElseThrow(() -> new IllegalArgumentException("xxxx")));

    }
}
