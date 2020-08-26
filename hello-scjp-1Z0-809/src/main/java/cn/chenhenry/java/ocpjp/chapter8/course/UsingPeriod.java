package cn.chenhenry.java.ocpjp.chapter8.course;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.beans.Expression;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class UsingPeriod {
    public static void main(String[] args) {
        LocalDate manufacturingDate = LocalDate.of(2016, Month.JANUARY, 1);
        LocalDate expiryDate = LocalDate.of(2018, Month.JULY, 18);
        Period expiry = Period.between(manufacturingDate, expiryDate);
        System.out.println(expiry);

        System.out.println(Period.ofWeeks(2));

        System.out.println(Period.ofDays(15));

        System.out.println(Period.ofMonths(3));

        System.out.println(Period.ofYears(1));

        System.out.println(Period.parse("P4Y6M15D"));
    }
}
