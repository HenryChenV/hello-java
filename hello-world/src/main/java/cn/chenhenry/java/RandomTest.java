package cn.chenhenry.java;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {
    @Test
    public void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }

    @Test
    public void testThreadLocalRandom() {
        System.out.println(1 << 30);
        System.out.println(1 << 31);
        System.out.println((int)(8589934592L));
//        ThreadLocalRandom random = new ThreadLocalRandom.current();
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt(5));
//        }
    }
}
