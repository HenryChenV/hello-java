package cn.chenhenry.java.ocpjp.chapter7.course;

import java.util.NoSuchElementException;
import java.util.Scanner;


class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String str) {
        super(str);
    }

    public InvalidInputException(Throwable originalException) {
        super(originalException);
    }

    public InvalidInputException(String str, Throwable originalException) {
        super(str, originalException);
    }

}

public class CustomExceptionTest {
    public static int readIntFromConsole() {
        Scanner consoleScanner = new Scanner(System.in);
        int typedInt = 0;

        try {
            typedInt = consoleScanner.nextInt();
        } catch (NoSuchElementException nsee) {
            System.out.println("Wrapping up the exception and throwing it...");
            // throw new InvalidInputException("Invalid integer input typed in console");
            throw new InvalidInputException("Invalid integer input typed in console", nsee);
        } catch (Exception e) {
            System.out.println("Error: Encountered an exception and could not read an integer from the console...");
        }
        return typedInt;
    }

    public static void main(String[] args) {
        System.out.println("Type an integer in the console: ");
        try {
            System.out.println("You typed the integer value: " + readIntFromConsole());
        } catch (InvalidInputException iie) {
            // System.out.println("Error: Invalid input in console... ");
            // System.out.println("The current caught exception is of type: " + iie);
            // System.out.println("The originally caught exception is of type: " + iie.getCause());

            iie.printStackTrace();
            // throw iie;
        }
    }
}
