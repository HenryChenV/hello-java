package cn.chenhenry.java.ocpjp.chapter8.course;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateTest {
}


class Hello {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate day = LocalDate.of(2018, Month.FEBRUARY, 28);
        System.out.println(day);
        System.out.println(day.plusDays(1));
        System.out.println(day);
        System.out.println(LocalDate.parse("2019-03-08"));
        System.out.println(Clock.systemDefaultZone());
    }
}
