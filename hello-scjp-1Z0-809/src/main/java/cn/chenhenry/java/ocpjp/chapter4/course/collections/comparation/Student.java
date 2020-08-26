package cn.chenhenry.java.ocpjp.chapter4.course.collections.comparation;

import javax.swing.*;
import java.awt.peer.CanvasPeer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable<Student> {
    String id;
    String name;
    Double cgpa;

    public Student(String studentId, String studentName, double studentCGPA) {
        id = studentId;
        name = studentName;
        cgpa = studentCGPA;
    }

    @Override
    public String toString() {
        return "\n " + id + "      \t  " + name + "      \t   " + cgpa;
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }
}


class ComparatorTest1 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("cs011", "Lennon   ", 3.1),
                new Student("cs021", "McCartney", 3.4),
                new Student("cs012", "Harrison ", 2.7),
                new Student("cs022", "Starr    ", 3.7)
        };

        System.out.println("Before sorting by student ID");
        System.out.println("Student-ID  \t  Name  \t  CGPA (for 4.0) ");
        System.out.println(Arrays.toString(students));

        Arrays.sort(students);

        System.out.println("After sorting by student ID");
        System.out.println("Student-ID  \t  Name  \t  CGPA (for 4.0) ");
        System.out.println(Arrays.toString(students));
    }
}


class CGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.cgpa.compareTo(s2.cgpa);
    }

}


class ComparatorTest2 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("cs011", "Lennon   ", 3.1),
                new Student("cs021", "McCartney", 3.4),
                new Student("cs012", "Harrison ", 2.7),
                new Student("cs022", "Starr    ", 3.7)
        };

        System.out.println("Before sorting by CGPA");
        System.out.println("Student-ID  \t  Name  \t  CGPA (for 4.0) ");
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, new CGPAComparator());

        System.out.println("After sorting by CGPA");
        System.out.println("Student-ID  \t  Name  \t  CGPA (for 4.0) ");
        System.out.println(Arrays.toString(students));
    }
}
