package cn.chenhenry.java.ocpjp.chapter8.course;

import java.time.LocalDateTime;

public class LocalDateTimeTest {}


class HelloLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);

        System.out.println(LocalDateTime.parse("2019-04-01T11:22:33"));
    }
}