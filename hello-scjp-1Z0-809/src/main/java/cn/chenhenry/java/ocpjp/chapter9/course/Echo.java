package cn.chenhenry.java.ocpjp.chapter9.course;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Echo {
    public static void main(String[] args) {
        String digits = "12345";
        for (int i = 0; i < 3; i++) {
        }
        Console console = System.console();
        if (null == console) {
            System.err.print(
                    "Cannot retrieve console object"
                    +" - are you running your application from an IDE?"
                    +" Exiting the application ... "
            );
            System.exit(-1);
        }

        StringBuffer a = new StringBuffer();
        LinkedList<Integer> b = new LinkedList<>();

        List<Character> elements = new LinkedList<>();

        console.printf(console.readLine());
    }
}

class StringFormat {
    public static void main(String[] args) {
        System.out.println(String.format("%2$s, %1$s", "hello", "world"));
        System.out.println(String.format("%d %<x %<o", 10));
    }
}
