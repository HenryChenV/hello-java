package cn.chenhenry.java.ocpjp.chapter9.course;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

public class StreamTest {
    public static void main(String[] args) {
        try {
            PrintStream ps = new PrintStream("log.txt");
            System.setOut(ps);
            System.out.println("Test output to System.out");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
