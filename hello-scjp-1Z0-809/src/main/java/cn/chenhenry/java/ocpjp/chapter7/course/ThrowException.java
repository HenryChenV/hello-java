package cn.chenhenry.java.ocpjp.chapter7.course;

class MyException extends Exception {
    MyException(String msg) {

    }
}

public class ThrowException {
    public static void main(String[] args) throws Exception {
        try {
            throw new Exception("try");
        } catch (Exception e) {
            throw new Exception("catch");
        } finally {
            throw new Exception("finally");
        }
    }

    public void throwRuntimeException() {
        throw new RuntimeException();
    }

    public void throwThrowalbe() throws Throwable {
        throw new Throwable();
    }

    public void throwError() {
        throw new Error();
    }

    public void throwMyException() throws MyException {
        throw new MyException("xxx");
    }
}
