package cn.chenhenry.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author henrychen
 * @date created at 2020/9/14 11:04 下午
 */
public class ArrayListTest {

    @Test
    public void testInitialCapacity() {
        List<Integer> list = new ArrayList<>(4);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list);
    }

}
