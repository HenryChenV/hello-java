package cn.chenhenry.java.ocpjp.chapter7.course;

import java.io.IOException;

class MyException1 extends Exception {}
class MyException2 extends Exception {}

interface IntReader1 {
    default int readIntFromFile() throws MyException1 {
        return 1;
    };
}

interface IntReader2 {
    default int readIntFromFile() throws MyException1 {
        return 2;
    };
}


public class ThrowsClause implements IntReader1, IntReader2 {

    ThrowsClause() {
    }


    public static void main(String[] args) throws Exception {
        ThrowsClause throwsClause = new ThrowsClause();
        try {
            System.out.println(throwsClause.readIntFromFile());
        } catch (MyException1 myException1) {
            myException1.printStackTrace();
            throw new Exception(myException1);
        }
    }

    @Override
    public int readIntFromFile() throws MyException1 {
        return 0;
    }
}
