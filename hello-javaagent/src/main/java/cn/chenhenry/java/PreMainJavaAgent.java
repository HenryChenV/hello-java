package cn.chenhenry.java;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @author henrychen
 * @date created at 2020/9/11 12:40 上午
 */
public class PreMainJavaAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("agentArgs: " + agentArgs);
        inst.addTransformer(new DefineTransformer(), true);
        inst.addTransformer(new DateConvertToAbbrTransformer(), true);
    }

    static class DefineTransformer implements ClassFileTransformer {

        @Override
        public byte[] transform(ClassLoader loader,
                                String className,
                                Class<?> classBeingRedefined,
                                ProtectionDomain protectionDomain,
                                byte[] classfileBuffer) throws IllegalClassFormatException {
            System.out.println("^-^ premain load Class: " + className + " ClassLoader: " + loader);
            return classfileBuffer;
        }
    }

    static class DateConvertToAbbrTransformer implements ClassFileTransformer {

        @Override
        public byte[] transform(ClassLoader loader,
                                String className,
                                Class<?> classBeingRedefined,
                                ProtectionDomain protectionDomain,
                                byte[] classfileBuffer) throws IllegalClassFormatException {
            // 操作Date类
            if ("java/util/Date".equals(className)) {
                System.out.println("O.O hack Date start");
                try {
                    // 从ClassPool获得CtClass对象
                    System.out.println("O.O hack Date debug");
                    final ClassPool classPool = ClassPool.getDefault();
                    final CtClass clazz = classPool.get("java.util.Date");
                    CtMethod convertToAbbr = clazz.getDeclaredMethod("convertToAbbr");
                    //这里对 java.util.Date.convertToAbbr() 方法进行了改写，在 return之前增加了一个 打印操作
                    String methodBody = "{$1.append(Character.toUpperCase($2.charAt(0)));" +
                            "$1.append($2.charAt(1)).append($2.charAt(2));" +
                            "$1.append(\"(---x.x---)\");" +
                            "System.out.println(\"O.O hello human\");" +
                            "return $1;}";
                    convertToAbbr.setBody(methodBody);

                    // 返回字节码，并且detachCtClass对象
                    byte[] byteCode = clazz.toBytecode();
                    //detach的意思是将内存中曾经被javassist加载过的Date对象移除，如果下次有需要在内存中找不到会重新走javassist加载
                    clazz.detach();
                    System.out.println("O.O hack Date end");
                    return byteCode;
                } catch (Throwable ex) {
                    System.out.println("O.O hack Date error x.x");
                    ex.printStackTrace();
                }
            }
            // 如果返回null则字节码不会被修改
            return null;
        }
    }

}
