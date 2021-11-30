package ru.croc.task17;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection createConnection(String connectionURL) throws SQLException {
        Driver driver = new org.h2.Driver();

        return DriverManager.getConnection(connectionURL);

    }
}
