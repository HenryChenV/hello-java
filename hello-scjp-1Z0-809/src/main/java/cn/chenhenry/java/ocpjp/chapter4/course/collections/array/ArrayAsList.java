package cn.chenhenry.java.ocpjp.chapter4.course.collections.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAsList {
    public static void main(String[] args) {
        Double[] temperatureArray = {31.1, 30.0, 32.5, 33.7, 27.8};
        System.out.println("the original array is: " + Arrays.toString(temperatureArray));

        List<Double> temperatureList = Arrays.asList(temperatureArray);
        temperatureList.set(0, 33.3);
        System.out.println("The modified array is: " + Arrays.toString(temperatureArray));
    }
}
