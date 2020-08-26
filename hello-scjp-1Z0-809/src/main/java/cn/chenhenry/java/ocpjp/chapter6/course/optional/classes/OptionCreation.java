package cn.chenhenry.java.ocpjp.chapter6.course.optional.classes;

import java.util.Optional;

public class OptionCreation {}


class OptionCreationNullable {
    public static void main(String[] args) {
        // Optional<String> nullStr = Optional.of(null);
        // System.out.println(nullStr);
        // crashes with a NullPointerException

        Optional<String> nullStr = Optional.ofNullable(null);
        System.out.println(nullStr);
        // prints: Optional.empty
    }
}
