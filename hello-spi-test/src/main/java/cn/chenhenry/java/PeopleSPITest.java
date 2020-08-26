package cn.chenhenry.java;

import java.util.ServiceLoader;

/**
 * @author henrychen
 * @date created at 2020/8/23 11:35 下午
 */
public class PeopleSPITest {
    public static void main(String[] args) {
        ServiceLoader<People> peoples = ServiceLoader.load(People.class);
        for (People people : peoples) {
            people.speak();
        }
    }
}
