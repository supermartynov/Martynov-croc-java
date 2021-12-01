package ru.croc.task17;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static final String connectionURL = "jdbc:h2:tcp://localhost/~/test";

    public static Connection createConnection() throws SQLException {
        Driver driver = new org.h2.Driver();
        return DriverManager.getConnection(connectionURL);
    }
}
