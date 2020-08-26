package cn.chenhenry.java.object.of.primitive.type;

import javax.swing.*;
import java.util.function.DoubleToIntFunction;

public class Demo {

    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Double price = demo != null ? demo.getPrice() : 0D;
        System.out.println(price);
    }
}
