package cn.chenhenry.java.ocpjp.chapter3.course.enums;

import java.util.Arrays;

enum PrinterType {

    DOTMATRIX(5),
    INKJET(10),
    LASER(50);

    private int pagePrintCapacity;

    private PrinterType(int pagePrintCapacity) {
        this.pagePrintCapacity = pagePrintCapacity;
    }
}

class someClass {
    enum EnumInSomeClass {
        CONSTANT1;
    }
}

public class EnumTest {
    private PrinterType printerType;

    public EnumTest(PrinterType pType) {
        printerType = pType;
    }

    public static void main(String[] args) {
        System.out.println(someClass.EnumInSomeClass.CONSTANT1);
        System.out.println(someClass.EnumInSomeClass.valueOf("CONSTANT1"));
        System.out.println(Arrays.toString(someClass.EnumInSomeClass.values()));
    }
}
