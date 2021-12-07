package ru.croc.task18.DAO_implementations;

import ru.croc.task17.DBConnection;
import ru.croc.task17.TableCreator;
import ru.croc.task18.DAO_interfaces.OrderDAO;
import ru.croc.task18.entities.Order;
import ru.croc.task18.entities.Product;

import java.sql.*;
import java.util.List;

public class OrderDAOImplementation implements OrderDAO {
    public  Connection connection;

     {
        try {
            connection = DBConnection.createConnection();
            TableCreator.createTables(connection);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables.getCause());
        }
    }

    @Override
    public Order createOrder(String userLogin, List<Product> products) throws SQLException {

        int lastOrderId = findMaxOrderId();
        int clientId = findClientIdByLogin(userLogin);
        if (clientId == -1) {
            throw new RuntimeException("Такого пользователя нет");
        }

        ProductDAOImplementation productDAO = new ProductDAOImplementation();
        String query = "INSERT INTO ORDERS (CLIENT_ID, PRODUCT_ID, ORDER_ID) VALUES (?, ?, ?)";
        Order order = new Order();
        order.setClientLogin(userLogin);

        for (Product product : products) {
            PreparedStatement statement = connection.prepareStatement(query);
            Product productFromDataBase = productDAO.findProduct(product.getProductCode());
            if (productFromDataBase == null) {
                product = productDAO.createProduct(product);
            } else if (!productFromDataBase.equals(product)) {
                throw new RuntimeException("Попытка введения уже существующего товара с неверными полями");
            } else if (productFromDataBase.equals(product)) {
                product = productFromDataBase;
            }
            statement.setInt(1, clientId);
            statement.setInt(2, product.getId());
            statement.setInt(3, lastOrderId + 1);
            statement.execute();
            statement.close();
            order.products.add(product);
        }
        return order;
    }

    private int findClientIdByLogin(String userLogin) throws SQLException {
        String query = "SELECT * FROM CLIENTS WHERE LOGIN = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, userLogin);

        try (ResultSet result = statement.executeQuery()) {
            while (result.next()) {
               return result.getInt("id");
            }
        }
        statement.close();
        return -1;
    }

    private int findMaxOrderId() throws SQLException {
        int id = 0;
        String query = "SELECT MAX(ORDER_ID) FROM ORDERS";
        Statement statement = connection.createStatement();
        statement.execute(query);
        try(ResultSet result = statement.getResultSet()) {
            while (result.next()) {
                id = result.getInt("MAX(ORDER_ID)");
            }
        }
        statement.close();
        return id;
    }
}
