package cn.chenhenry.java.ocpjp.chapter5.course.buidin.functional.interfaces.supplier;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class GenerateBooleans {
    public static void main(String[] args) {
        Random randon = new Random();
        Stream.generate(randon::nextBoolean)
                .limit(2)
                .forEach(System.out::println);

        Supplier<String> currentDateTime = () -> LocalDateTime.now().toString();
        System.out.println(currentDateTime.get());
        System.out.println(currentDateTime.get());
        System.out.println(currentDateTime.get());
        System.out.println(Integer.MIN_VALUE);
    }
}
