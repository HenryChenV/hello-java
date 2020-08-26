package cn.chenhenry.java.ocpjp.chapter8.course;

import java.time.*;

public class UsingZonedDatetime {
    public static void main(String[] args) {
        System.out.println(ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.systemDefault()));

        LocalDateTime dateTime = LocalDateTime.now();
        ZoneId myZone = ZoneId.of("Asia/Kolkata");
        ZonedDateTime zonedDateTime = dateTime.atZone(myZone);
        ZoneOffset zoneOffset = zonedDateTime.getOffset();
        System.out.println(
                "\ndateTime="+dateTime
                        +"\nmyZone="+myZone
                        +"\nzoneDateTime="+zonedDateTime
                        +"\nzoneOffset="+zoneOffset
        );
    }
}
