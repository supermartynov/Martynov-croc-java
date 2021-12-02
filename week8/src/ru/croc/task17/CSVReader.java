package ru.croc.task17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CSVReader {
    private String csv;

    private Connection connection;

    public static final String selectProductQuery = "SELECT * FROM PRODUCTS WHERE article = ?";

    public static final String selectClientsQuery = "SELECT * FROM CLIENTS WHERE login = ?";

    public static final String insertIntoClientsQuery = "INSERT INTO CLIENTS (login) values (?)";

    public static final String insertIntoProductsQuery = "INSERT INTO PRODUCTS (name, price, article) values (?, ?, ?)";

    public static final String insertIntoOrderQuery = "INSERT INTO ORDERS (client_id, product_id, order_id) values (?, ?, ?)";

    public CSVReader(String csvPath, Connection connection) {
        csv = csvPath;
        this.connection = connection;
    }

    public  void fillTablesFromCSV () throws IOException, SQLException {
        FileReader fileReader = new FileReader(csv);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            String[] strings = bufferedReader.readLine().split(",");
            int order_id = Integer.parseInt(strings[0]);
            String login = strings[1];
            String article = strings[2];
            String name = strings[3];
            String price = strings[4];

            int product_id = insertIntoProducts(article, name, Integer.parseInt(price.trim()));
            int client_id = insertIntoClients(login);
            insertIntoOrders(client_id, product_id, order_id);
        }
    }

    private int insertIntoProducts(String article, String name, int price) throws SQLException {
        int id = selectFromTableByOneArgument(article, selectProductQuery);

        if (id == -1) {
            PreparedStatement statementForInsertProduct = connection.prepareStatement(insertIntoProductsQuery);
            statementForInsertProduct.setString(1, name);
            statementForInsertProduct.setInt(2, price);
            statementForInsertProduct.setString(3, article);
            statementForInsertProduct.execute();
            return selectFromTableByOneArgument(article, selectProductQuery);
        } else {
            return id;
        }
    }

    private int insertIntoClients(String login) throws SQLException {
        int id = selectFromTableByOneArgument(login, selectClientsQuery);

        if (id == -1) {
            PreparedStatement statementForInsertProduct = connection.prepareStatement(insertIntoClientsQuery);
            statementForInsertProduct.setString(1, login);
            statementForInsertProduct.execute();
            return selectFromTableByOneArgument(login, selectClientsQuery);
        } else {
            return id;
        }
    }

    private void insertIntoOrders(int client_id, int product_id, int order_id) throws SQLException {
        PreparedStatement statementForInsertProduct = connection.prepareStatement(insertIntoOrderQuery);
        statementForInsertProduct.setInt(1, client_id);
        statementForInsertProduct.setInt(2, product_id);
        statementForInsertProduct.setInt(3, order_id);
        statementForInsertProduct.execute();

    }

    private int selectFromTableByOneArgument(String article, String query) throws SQLException {
        int id = -1;
        PreparedStatement statementForSelectQuery = connection.prepareStatement(query);
        statementForSelectQuery.setString(1, article);
        try (ResultSet result = statementForSelectQuery.executeQuery()) {
            while (result.next()) {
                id = result.getInt("id");
            }
        }
        return id;
    }
}
