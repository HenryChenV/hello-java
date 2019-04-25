package cn.chenhenry.java.ocpjp.chapter12.course;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";

        String database = "addressBook";

        String userName = "root";
        String password = "root";

        System.out.println(DriverManager.getDriver(url).getClass().getName());

        try (Connection connection = DriverManager.getConnection(url + database, userName, password);
             ) {
            System.out.println("^-^ Database connection: Successful");
        } catch (SQLException e) {
            System.out.println("x.x Database connection: Failed");
            e.printStackTrace();
        }
    }
}
