package cn.chenhenry.java.ocpjp.chapter9.course;

import java.io.IOException;

public class Read {
    public static void main(String[] args) {
        System.out.println("Type a character: ");

        int val = 0;

        try {
            val = System.in.read();
        } catch (IOException ioe) {
            System.err.print("Cannot read input " + ioe);
            System.exit(-1);
        }

        System.out.println("You typed: " + val);
    }
}
