package cn.chenhenry.java.ocpjp.chapter11.course;

import com.sun.tools.javac.processing.JavacProcessingEnvironment;

import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumOfNUsingForkJoin {

    private static long N = 1000_000;

    private static final int NUM_THREADS = 10;

    static class RecursiveSumOfN extends RecursiveTask<Long> {

        long from, to;

        public RecursiveSumOfN(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            try {
                System.out.println("Sleep for a while.");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if ((to - from) <= N/NUM_THREADS) {
                long localSum = 0;

                for (long i = from; i <= to; i++) {
                    localSum += i;
                }

                System.out.printf("\tSum of value range %d to %d is %d %n", from, to, localSum);

                return localSum;
            }

            long mid = (from + to) / 2;

            System.out.printf("Forking computation into two ranges: %d to %d and %d to %d %n",
                    from, mid, mid + 1, to);

            RecursiveSumOfN firstHalf = new RecursiveSumOfN(from, mid);
            firstHalf.fork();

            RecursiveSumOfN secondHalf = new RecursiveSumOfN(mid + 1, to);
            long resultSecond = secondHalf.compute();

            return firstHalf.join() + resultSecond;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(NUM_THREADS);

        long computedSum = pool.invoke(new RecursiveSumOfN(0, N));

        long formulaSum = (N * (N + 1)) / 2;

        System.out.printf("Sum for range 1..%d; computed sum = %d, formula sum = %d %n", N, computedSum, formulaSum);
    }

}
