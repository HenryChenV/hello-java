package cn.chenhenry.java.ocpjp.chapter4.exam.question3;

import java.util.Arrays;

public class DefaultSorter {
    public static void main(String[] args) {
        String[] brics = {"Brazil", "Russia", "India", "China"};
        Arrays.sort(brics, null);
        for (String country : brics) {
            System.out.printf(country + " ");
        }
    }
}
