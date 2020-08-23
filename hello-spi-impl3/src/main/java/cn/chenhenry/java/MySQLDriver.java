package cn.chenhenry.java;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author henrychen
 * @date created at 2020/8/23 11:49 下午
 */
public class MySQLDriver implements Driver {
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        System.out.println("connect to MySQL");
        return null;
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
