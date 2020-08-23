package cn.chenhenry.java;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.ServiceLoader;

/**
 * @author henrychen
 * @date created at 2020/8/23 11:52 下午
 */
public class DriverSPITest {
    public static void main(String[] args) {
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        for (Driver driver : drivers) {
            try {
                driver.connect(null, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
    }
}
