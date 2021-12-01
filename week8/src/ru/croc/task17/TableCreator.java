package ru.croc.task17;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

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

    public static void createTables (Connection connection) throws SQLException {
        connection = DBConnection.createConnection();
        executeStatement(createUserTableQuery, connection);
        executeStatement(createProductTableQuery, connection);
        executeStatement(createOrderTableQuery, connection);
    }

    public static void executeStatement(String query, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

}
