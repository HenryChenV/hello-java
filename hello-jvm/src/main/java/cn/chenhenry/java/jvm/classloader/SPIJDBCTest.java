package cn.chenhenry.java.jvm.classloader;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

/**
 * @author henrychen
 * @date created at 2020/8/23 10:19 下午
 */
public class SPIJDBCTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        try {
            Connection conn = java.sql.DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
