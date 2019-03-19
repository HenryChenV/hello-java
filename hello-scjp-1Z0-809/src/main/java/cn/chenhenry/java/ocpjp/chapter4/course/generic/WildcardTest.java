package cn.chenhenry.java.ocpjp.chapter4.course.generic;

class Food {}

class Fruit extends Food {}
class Meat extends Food {}

class Apple extends Fruit {}
class Banana extends Fruit {}
class Pork extends Meat {}
class Beef extends Meat {}

class RedApple extends Apple {}
class GreenApple extends Apple {}


class Plate<T> {
    private T item;

    public Plate(T t) {
        item = t;
    }

    public void set(T t) {
        item = t;
    }

    public T get() {
        return item;
    }
}


public class WildcardTest {
    public static void main(String[] args) {
        // Plate<Fruit> p1 = new Plate<Apple>(new Apple());  // Compile Error

        Plate<? extends Fruit> p2 = new Plate<Apple>(new Apple());
        // p2.set(new Apple()):  // Compile Error
        // p2.set(new Fruit()):  // Compile Error
        // p2.set(new Food()):  // Compile Error
        System.out.println(p2.get());

        Plate<? super Fruit> p3 = new Plate<Food>(new Food());
        // Plate<? super Fruit> p4 = new Plate<Apple>(new Apple());  // Compile Error
        Plate<? super Fruit> p5 = new Plate<Fruit>(new Fruit());
        p3.set(new Apple());
        // Food a1 = p3.get();  // Compile Error
        Object o = p3.get();  // Only Object is correct
        p3.set(new Fruit());
        // p3.set(new Food());  // Compile Error
        System.out.println(p3.get());
    }
}
