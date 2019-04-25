package cn.chenhenry.java.ocpjp.base.utils;


import sun.security.ssl.Debug;

import java.time.Instant;

public class DebugUtils {
    public static void timeWrapped(Runnable runnable) {
        String logPrefix = DebugUtils.class.getSimpleName() + ": ";

        Instant startedAt = Instant.now();
        System.out.println(logPrefix + "Started At " + startedAt);

        runnable.run();

        Instant endedAt = Instant.now();
        System.out.println(logPrefix + "Ended At " + endedAt);

        System.out.println(logPrefix + "Time: " + (endedAt.toEpochMilli() - startedAt.toEpochMilli()) + " ms.");
        System.out.println();
    }
}
