package cn.chenhenry.java.ocpjp.chapter5.course.buidin.functional.interfaces.predicate;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfMethodTest {
    public static void main(String[] args) {
        List<String> greetins = new ArrayList<>();
        greetins.add("hello");
        greetins.add("world");

        // greetins.removeIf(str -> !str.startsWith("h"));
        greetins.removeIf(((Predicate<String>) str -> str.startsWith("h")).negate());
        greetins.forEach(System.out::println);
    }
}
