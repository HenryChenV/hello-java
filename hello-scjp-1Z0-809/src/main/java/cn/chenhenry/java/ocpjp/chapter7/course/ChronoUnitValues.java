package cn.chenhenry.java.ocpjp.chapter7.course;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ChronoUnitValues {
    public static void main(String[] args) {
        System.out.println("ChronoUnit \t DateBased \t TimeBased \t Duration");
        System.out.println("------------------------------------------------");
        for(ChronoUnit unit : ChronoUnit.values()) {
            System.out.printf("%10s \t %b \t\t %b \t\t %s %n",
                    unit, unit.isDateBased(), unit.isTimeBased(), unit.getDuration());
        }

        System.out.println(Duration.of(1, ChronoUnit.MINUTES).getSeconds());
        System.out.println(Duration.of(1, ChronoUnit.HOURS).getSeconds());
        System.out.println(Duration.of(1, ChronoUnit.DAYS).getSeconds());
    }
}
