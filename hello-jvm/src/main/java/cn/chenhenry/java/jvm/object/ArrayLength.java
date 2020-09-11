package cn.chenhenry.java.jvm.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author henrychen
 * @date created at 2020/9/3 10:35 上午
 */
public class ArrayLength {

    public static void main(String[] args) {
        int[] arr = {2, 2, 2};

        int len = arr.length;

        System.out.println(ClassLayout.parseInstance(arr).toPrintable());

        while (true);
    }

}
