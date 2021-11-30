package ru.croc.task18;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static final String connectionURL = "jdbc:h2:tcp://localhost/~/test";

    public static Connection connection;

    public static void main(String[] args) {
        Driver driver = new org.h2.Driver();
        try {
            connection = DriverManager.getConnection(connectionURL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
