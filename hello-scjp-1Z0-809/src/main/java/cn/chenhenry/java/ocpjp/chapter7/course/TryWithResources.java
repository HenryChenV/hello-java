package cn.chenhenry.java.ocpjp.chapter7.course;

import java.util.Scanner;

public class TryWithResources {
}

class TryWithResources1 {
    public static void main(String[] args) {
        System.out.println("Type an integer in the console: ");

        try (
                Scanner consoleScanner = new Scanner(System.in);
                Scanner consoleScanner2 = new Scanner(System.in);
        ) {
            System.out.println("You typed the integer value: " + consoleScanner.nextInt());
        } catch (Exception e) {
            System.out.println("Exiting the program - restart and try the program again!");
        } finally {

        }
    }
}
