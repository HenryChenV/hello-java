package cn.chenhenry.java.ocpjp.chapter8.course;

import java.security.Signature;
import java.time.*;

public class TimeDifference {
    public static void main(String[] args) {
        ZoneId singaporeZone = ZoneId.of("Asia/Singapore");
        ZonedDateTime dateTimeInSingapore = ZonedDateTime.of(
                LocalDateTime.of(2016, Month.JANUARY, 1, 6, 0),
                singaporeZone
        );

        ZoneId aucklandZone = ZoneId.of("Pacific/Auckland");
        ZonedDateTime sameDateTimeInAuckland = dateTimeInSingapore.withZoneSameInstant(aucklandZone);

        Duration timeDifference = Duration.between(
                dateTimeInSingapore.toLocalDateTime(),
                sameDateTimeInAuckland.toLocalDateTime()
        );

        System.out.println(dateTimeInSingapore);
        System.out.println(dateTimeInSingapore.toLocalDateTime());

        System.out.println(sameDateTimeInAuckland);
        System.out.println(sameDateTimeInAuckland.toLocalDateTime());

        System.out.println(timeDifference);

        System.out.println(Duration.between(
                dateTimeInSingapore,
                sameDateTimeInAuckland
        ));
        System.out.println(dateTimeInSingapore.getZone());
    }
}
