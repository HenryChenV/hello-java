package cn.chenhenry.java.ocpjp.chapter8.course;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class UsingDateTimeFormatter {
    public static void main(String[] args) {
        System.out.println(
                DateTimeFormatter.ISO_TIME.format(LocalTime.of(6, 0, 0))
        );

        System.out.println(
                DateTimeFormatter
                        .ofPattern("dd MMM yyyy")
                        .format(LocalDate.of(2016, Month.JANUARY, 01))
        );
    }
}
