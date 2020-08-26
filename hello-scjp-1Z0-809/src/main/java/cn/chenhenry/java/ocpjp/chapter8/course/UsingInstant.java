package cn.chenhenry.java.ocpjp.chapter8.course;

import java.time.Instant;
import java.time.LocalDateTime;

public class UsingInstant {
    public static void main(String[] args) {
        Instant currTimeStamp = Instant.now();

        System.out.println(currTimeStamp);

        System.out.println(currTimeStamp.getEpochSecond());

        System.out.println(currTimeStamp.toEpochMilli());

        System.out.println(LocalDateTime.now());
    }
}
