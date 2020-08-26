package cn.chenhenry.java.ocpjp.chapter3.course.lambda;

@FunctionalInterface
interface LambdaFunction {
    void call();
}

public class FirstLambda {
    public static void main(String[] args) {
        LambdaFunction lambdaFunction = () -> System.out.println("Hello Lambda!");
        lambdaFunction.call();
    }
}
