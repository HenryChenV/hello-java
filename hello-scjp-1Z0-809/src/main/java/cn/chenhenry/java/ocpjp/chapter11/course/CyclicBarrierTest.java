package cn.chenhenry.java.ocpjp.chapter11.course;

import java.util.concurrent.*;

class MixedDoubleTennisGame extends Thread {
    @Override
    public void run() {
        System.out.println("All four players ready, game starts \n Love all...");
    }
}


class Player extends Thread {
    CyclicBarrier waitPoint;

    public Player(CyclicBarrier barrier, String name) {
        this.setName(name);
        waitPoint = barrier;
        this.start();
    }

    @Override
    public void run() {
        System.out.println("Player " + getName() + " is ready ");
        try {
            // wait for all four players to arrive
            waitPoint.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println(getName() + ": An exception occurred while waiting... " + e);
        } catch (TimeoutException e) {
            System.out.println("Time Over " + e);
        }
    }
}


public class CyclicBarrierTest {
    public static void main(String[] args) {
        System.out.println("Reserving tennis court \n" + "As soon as four players arrive, game will start");

        CyclicBarrier barrier = new CyclicBarrier(4, new MixedDoubleTennisGame());

        new Player(barrier, "G I Joe");
        new Player(barrier, "Dora");
        new Player(barrier, "Tintin");
        // new Player(barrier, "Barbie");
    }
}
