package cn.chenhenry.java.ocpjp.chapter11.course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWList {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> aList = new CopyOnWriteArrayList<>();
        aList.add("one");
        aList.add("two");
        aList.add("three");

        System.out.println(aList);

        Iterator listIter = aList.iterator();
        while (listIter.hasNext()) {
            System.out.println(listIter.next());
            aList.add("four");
        }

        System.out.println(aList);
    }
}
