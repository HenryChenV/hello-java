package cn.chenhenry.java.ocpjp.chapter4.course.collections.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class SqlQueue {
    private Deque<String> sqlQ = new ArrayDeque<>();

    void addInQueue(String customer) {
        sqlQ.addLast(customer);
    }

    String removeFront() {
        return sqlQ.removeFirst();
    }

    String removeBack() {
        return sqlQ.removeLast();
    }

    void printQueue() {
        System.out.println("Special queue contains: " + sqlQ);
    }
}


class SqlQqueueTest {
    public static void main(String[] args) {
        SqlQueue sqlQ = new SqlQueue();

        sqlQ.addInQueue("Harrison");
        sqlQ.addInQueue("McCartney");
        sqlQ.addInQueue("Starr");
        sqlQ.addInQueue("Lennon");

        sqlQ.printQueue();

        System.out.println(sqlQ.removeFront());
        System.out.println(sqlQ.removeBack());

        sqlQ.printQueue();
    }
}
