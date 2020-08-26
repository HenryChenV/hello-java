package cn.chenhenry.java.ocpjp.chapter11.course.parallel.stream;

import cn.chenhenry.java.ocpjp.base.utils.DebugUtils;

import java.util.stream.LongStream;

public class PrimeNumber {
    private static boolean isPrime(long val) {
        for (int i = 2; i <= val / 2; i++) {
            if (0 == (val % i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DebugUtils.timeWrapped(() -> {
            long numOfPrimes = LongStream.rangeClosed(2, 100_000)
                    .filter(PrimeNumber::isPrime)
                    .count();
            System.out.println("Sequential Result=" + numOfPrimes);
        });

        DebugUtils.timeWrapped(() -> {
            long numOfPrimes = LongStream.rangeClosed(2, 100_000)
                    .parallel()
                    .filter(PrimeNumber::isPrime)
                    .count();
            System.out.println("Parallel Result=" + numOfPrimes);
        });
    }
}
