package cn.chenhenry.java.ocpjp.chapter9.course;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ClassFileMagicNumberChecker {
    private static final byte[] MAGIC_NUMBER = {(byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE};
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Pass a valid name as argument");
            System.exit(-1);
        }

        String fileName = args[0];

        try (FileInputStream fis = new FileInputStream(fileName)) {
            byte[] u4buffer = new byte[4];
            if (fis.read(u4buffer) != -1) {
                if (Arrays.equals(MAGIC_NUMBER, u4buffer)) {
                    System.out.printf("The magic number for passed file '%s' " + "matches that of a .class file", fileName);
                } else {
                    System.out.printf("The magic number of passed file '%s' does not match that of a .class file", fileName);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("file does not exist with the given file name");
        } catch (IOException e) {
            System.err.println("an I/O error occurred while processing the file");
        }
    }
}
