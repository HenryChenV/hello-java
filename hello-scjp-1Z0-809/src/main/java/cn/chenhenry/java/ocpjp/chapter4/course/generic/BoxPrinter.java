package cn.chenhenry.java.ocpjp.chapter4.course.generic;

class BoxPrinter<T> {
    private T val;

    public BoxPrinter(T arg) {
        val = arg;
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}

class BoxPrinterTest {
    public static void main(String[] args) {
        BoxPrinter<Integer> boxPrinter = new BoxPrinter<>(10);
        System.out.println(boxPrinter);

        System.out.println(new BoxPrinter<>(10));

        System.out.println(new BoxPrinter<>("Hello World"));
    }
}
