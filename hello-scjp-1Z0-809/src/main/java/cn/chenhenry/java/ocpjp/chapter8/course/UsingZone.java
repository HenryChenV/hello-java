package cn.chenhenry.java.ocpjp.chapter8.course;

import java.time.ZoneId;
import java.util.Set;

public class UsingZone {
    public static void main(String[] args) {
        Set<String> zones = ZoneId.getAvailableZoneIds();
        zones.forEach(System.out::println);
    }
}
