package cn.chenhenry.java.ocpjp.chapter4.course.collections.array;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArray {
    public static void main(String[] args) {
        ArrayList<String> languangeList = new ArrayList<>();
        languangeList.add("C");
        languangeList.add("C++");
        languangeList.add("Java");

        for (String languange : languangeList) {
            System.out.println(languange);
        }

        for (Iterator<String> languangeIter = languangeList.iterator(); languangeIter.hasNext();) {
            System.out.println(languangeIter.next());
        }
    }
}
