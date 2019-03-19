package cn.chenhenry.java.sychronized;

import org.junit.Test;

import java.sql.Statement;

public class SyncTest {

    private Sync sync = new Sync();

    @Test
    public void test1() {
        sync.r1m1Thread.start();
        sync.r1m2Thread.start();

        try {
            sync.r1m1Thread.join();
            sync.r1m2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        sync.r1m1Thread.start();
        sync.r2m2Thread.start();

        try {
            sync.r1m1Thread.join();
            sync.r2m2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        sync.r1m1Thread.start();
        sync.r1m4Thread.start();

        try {
            sync.r1m1Thread.join();
            sync.r1m4Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        sync.r1m4Thread.start();
        sync.r2m4Thread.start();

        try {
            sync.r1m4Thread.join();
            sync.r2m4Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}