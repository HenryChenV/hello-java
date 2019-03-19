package cn.chenhenry.java.ocpjp.chapter4.course.generic;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class RawTest1 {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("First");
        list.add("Second");
        List<String> strList = list;
        for (Iterator<String> itemItr = strList.iterator(); itemItr.hasNext();) {
            System.out.println("Item: " + itemItr.next());
        }

        List<String> strList2 = new LinkedList<>();
        strList2.add("First");
        strList2.add("Second");
        List list2 = strList2;
        for (Iterator<String> itemItr = list2.iterator(); itemItr.hasNext();) {
            System.out.println("Item: " + itemItr.next());
        }
    }
}


class RawTest2 {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("First");
        list.add("Second");
        List<String> strList = list;
        // strList.add(10); // generate compiler error
        for (Iterator<String> itemItr = strList.iterator(); itemItr.hasNext();) {
            System.out.println("Item: " + itemItr.next());
        }

        List<String> strList2 = new LinkedList<>();
        strList2.add("First");
        strList2.add("Second");
        List list2 = strList2;
        list2.add(10); // compiles fine, results in runtime exception
        for (Iterator<String> itemItr = list2.iterator(); itemItr.hasNext();) {
            System.out.println("Item: " + itemItr.next());
        }
    }
}


public class RawTest {
}
