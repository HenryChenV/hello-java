package cn.chenhenry.java.ocpjp.chapter11.course;


import java.util.concurrent.*;

class Factorial implements Callable<Long> {
    long n;

    public Factorial(long n) {
        this.n = n;
    }

    @Override
    public Long call() throws Exception {
        Thread.sleep(10000);
        if (n <= 0) {
            throw new Exception("for finding factorial, N should be > 0");
        }

        long fact = 1;
        for (long longVal = 1; longVal <= n; longVal++) {
            fact *= longVal;
        }

        return fact;
    }
}


public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long N = 20;

        Callable<Long> task = new Factorial(N);

        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Long> future = es.submit(task);
        System.out.printf("factorial of %d is %d", N, future.get());
        es.shutdown();
    }
}
