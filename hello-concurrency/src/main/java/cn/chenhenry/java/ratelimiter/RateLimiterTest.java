package cn.chenhenry.java.ratelimiter;

import com.revinate.guava.util.concurrent.RateLimiter;

public class RateLimiterTest {
    public static void main(String[] args) {
        RateLimiter.create(2.0);
    }
}
