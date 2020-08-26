package cn.chenhenry.java.ocpjp.chapter8.course;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UsingDuration {
    public static void main(String[] args) {
        LocalDateTime comingMidnight = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT);
        LocalDateTime now = LocalDateTime.now();

        Duration between = Duration.between(now, comingMidnight);
        System.out.println(between);
        System.out.println(Duration.between(comingMidnight, now));
    }
}
