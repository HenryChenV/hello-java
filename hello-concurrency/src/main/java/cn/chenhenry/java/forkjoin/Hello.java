package cn.chenhenry.java.forkjoin;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Hello {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list);
        for (Integer num : list) {
            list.remove(num);
        }

        System.out.println(list);
    }
}
