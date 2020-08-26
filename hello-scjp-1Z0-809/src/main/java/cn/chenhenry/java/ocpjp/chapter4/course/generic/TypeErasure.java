package cn.chenhenry.java.ocpjp.chapter4.course.generic;


import com.sun.tools.javah.Gen;

import java.nio.file.Files;

class G<T> {
    private T val;

    G(T val) {
        this.val = val;
    }


}

public class TypeErasure {
    public static void main(String[] args) {
        G<Integer> a = new G<>(111);
        G<String> b = new G<>("bbb");

        Class<? extends G> classOfA = a.getClass();
        Class<? extends G> classOfB = b.getClass();

        System.out.println("a's class: " + classOfA.getName());
        System.out.println("b's class: " + classOfB.getName());
        System.out.println("G's class: " + G.class.getName());
        System.out.println("a'class == b'class == G'class: " + (classOfA == classOfB && classOfB == G.class));
    }
}
