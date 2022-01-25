package cn.chenhenry.java.ocpjp.chapter7.course;


import java.util.*;

public class ScanInt {
    public static void main(String[] args) {
        System.out.println("Type an integer in the console: ");
        Scanner consoleScanner = new Scanner(System.in);

        System.out.println();

        try {
            System.out.println("You typed the integer value: " + consoleScanner.nextInt());
        } catch (InputMismatchException ime) {
            System.out.println("Error: You typed some text that is not an integer value...");
        } finally {
            consoleScanner.close();
        }
    }
}
