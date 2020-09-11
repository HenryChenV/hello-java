package cn.chenhenry.java.jvm.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * 计算空对象大小
 * @author henrychen
 * @date created at 2020/9/1 11:01 上午
 */
public class CountObjectSize {

    int a = 10;
    int b = 20;

    public static void main(String[] args) {
        CountObjectSize obj = new CountObjectSize();

        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        while (true);
    }

}
