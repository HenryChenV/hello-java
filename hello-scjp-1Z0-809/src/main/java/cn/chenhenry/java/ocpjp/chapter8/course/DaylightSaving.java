package cn.chenhenry.java.ocpjp.chapter8.course;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class DaylightSaving {
    public static void main(String[] args) {
        List<ZoneId> zoneIds = Arrays.asList(
                ZoneId.of("Asia/Kolkata"),
                ZoneId.of("Pacific/Auckland"),
                ZoneId.of("Asia/Shanghai")
        );

        for (ZoneId zoneId : zoneIds) {
            Duration dst = zoneId.getRules().getDaylightSavings(Instant.now());
            System.out.printf("%s: %s hours\n", zoneId, dst.toHours());
        }
    }
}
