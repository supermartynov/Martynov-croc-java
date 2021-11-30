package ru.croc.task17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {
    public static final String connectionURL = "jdbc:h2:tcp://localhost/~/test";

    public static Connection connection;

    public static final String createUserTableQuery = "CREATE TABLE IF NOT EXISTS CLIENTS (" +
            "id INT IDENTITY PRIMARY KEY ," +
            "login VARCHAR(50))";

    public static final String createProductTableQuery = "CREATE TABLE IF NOT EXISTS PRODUCTS (" +
            "id INT IDENTITY PRIMARY KEY," +
            "name VARCHAR(50) NOT NULL," +
            "article VARCHAR(30) NOT NULL," +
            "price int NOT NULL)";

    public static final String createOrderTableQuery = "CREATE TABLE IF NOT EXISTS ORDERS (" +
            "id INT IDENTITY PRIMARY KEY," +
            "client_id int NOT NULL," +
            "product_id int NOT NULL," +
            "foreign key(client_id) references clients(id)," +
            "foreign key(product_id) references products(id))";



    public static void main(String[] args) throws SQLException, IOException {
        Driver driver = new org.h2.Driver();
        try {
            connection = DriverManager.getConnection(connectionURL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        executeStatement(createUserTableQuery);
        executeStatement(createProductTableQuery);
        executeStatement(createOrderTableQuery);
        CSVReader csvReader = new CSVReader(args[0], connection);
        csvReader.fillTablesFromCSV();
    }

    public static void executeStatement(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(query);
    }


}
