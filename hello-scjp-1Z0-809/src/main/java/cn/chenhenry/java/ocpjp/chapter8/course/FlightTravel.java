package cn.chenhenry.java.ocpjp.chapter8.course;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class FlightTravel {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh.mm a");

        ZonedDateTime departure = ZonedDateTime.of(
                LocalDateTime.of(2016, Month.JANUARY, 1, 6, 0),
                ZoneId.of("Asia/Singapore")
        );
        System.out.println("Departure: " + dateTimeFormatter.format(departure));

        ZonedDateTime arrival = departure.withZoneSameInstant(ZoneId.of("Pacific/Auckland"))
                .plusHours(10);
        System.out.println("Arrival: " + dateTimeFormatter.format(arrival));

        System.out.println(LocalDateTime.now());

    }
}
