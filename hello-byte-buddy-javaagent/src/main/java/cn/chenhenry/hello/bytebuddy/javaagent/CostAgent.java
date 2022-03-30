package cn.chenhenry.hello.bytebuddy.javaagent;


import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;
import sun.management.Agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * @author chenhanli
 * @date 2022/3/20 9:21 下午
 */
public class CostAgent {

    public static class CostInterceptor {

        @RuntimeType
        public static Object intercept(@Origin Method method,
                                       @AllArguments Object[] arguments,
                                       @SuperCall Callable<?> callable) throws Exception {
            long start = System.nanoTime();
            try {
                return callable.call();
            } finally {
                System.out.println(method +
                        " took " + ((System.nanoTime() - start) * 0.000001) + "ms" +
                        " arguments=" + Arrays.toString(arguments));
            }
        }

    }

    public static void premain(String arguments, Instrumentation instrumentation) {
        System.out.println("init" + CostAgent.class.getName() + " with arguments: " + arguments);
        new AgentBuilder.Default()
                .type(ElementMatchers.nameEndsWith("Demo"))
                .transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder,
                                                            TypeDescription typeDescription,
                                                            ClassLoader classLoader,
                                                            JavaModule module) {
                        return builder.method(ElementMatchers.any())
                                .intercept(MethodDelegation.to(CostInterceptor.class));
                    }
                }).installOn(instrumentation);

        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                return classfileBuffer;
            }
        });
    }
}
