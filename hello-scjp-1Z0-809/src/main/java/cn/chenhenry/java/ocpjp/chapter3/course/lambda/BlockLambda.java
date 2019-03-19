package cn.chenhenry.java.ocpjp.chapter3.course.lambda;

public class BlockLambda {

    interface LambdaFunction {
        String intKind(int a);
    }

    public void call() {
        int a;
        LambdaFunction lambdaFunction = (i) -> {
            System.out.println("This is " + this);
            if ((i % 2) == 0) {
                return "even";
            }
            return "odd";
        };

        System.out.println(lambdaFunction.intKind(10));
        System.out.println(lambdaFunction.intKind(11));
    }

    public static void main(String[] args) {
        BlockLambda blockLambda = new BlockLambda();
        blockLambda.call();
    }

}

class AnonymousInnerClass {
    interface Function {
        void call();
    }

    public static void main(String[] args) {
        Function function = new Function() {
            @Override
            public void call() {
                System.out.println("Hello Anonymous Inner Class!");
            }
        };
        function.call();
    }
}
