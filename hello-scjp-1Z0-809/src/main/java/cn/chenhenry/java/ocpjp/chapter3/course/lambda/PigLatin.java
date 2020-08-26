package cn.chenhenry.java.ocpjp.chapter3.course.lambda;

@FunctionalInterface
interface SuffixFunction {
    void call();
}

public class PigLatin {
    public static void main(String[] args) {
        String word = "hello";
        SuffixFunction suffixFunction = () -> System.out.println(word + "ay");
        suffixFunction.call();
    }
}
