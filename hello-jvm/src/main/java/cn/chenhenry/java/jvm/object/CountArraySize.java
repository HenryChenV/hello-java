package cn.chenhenry.java.jvm.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author henrychen
 * @date created at 2020/9/1 10:11 下午
 */
public class CountArraySize {

    public static int[] arr = {1, 2, 3};

    public static void main(String[] args) {
        CountArraySize obj = new CountArraySize();
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
        while (true);
    }

}
