package ru.croc.task18.DAO_implementations;

import ru.croc.task17.DBConnection;
import ru.croc.task17.TableCreator;
import ru.croc.task18.DAO_interfaces.ProductDAO;
import ru.croc.task18.entities.Product;

import java.sql.*;

public class ProductDAOImplementation implements ProductDAO {

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
    public Product findProduct(String productCode) throws SQLException {
        String query = "SELECT * FROM PRODUCTS WHERE ARTICLE = ?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, productCode);
            Product product = null;

            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    String code = result.getString("article");
                    int price = result.getInt("price");
                    product = new Product(id, code, name, price);
                }
            }
            return product;
        }

    }

    @Override
    public Product createProduct(Product product) throws SQLException {

        if (findProduct(product.getProductCode()) != null) {
            throw new RuntimeException("товар с таким артикулом");
        }

        String query = "INSERT INTO PRODUCTS (name, article, price) VALUES (?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getProductCode());
            statement.setInt(3, product.getPrice());
            statement.execute();
            return findProduct(product.getProductCode());
        }
    }

    @Override
    public Product updateProduct(Product product) throws SQLException {
        Product productToChange = findProduct(product.getProductCode());
        if (productToChange  == null) {
            throw new RuntimeException("Товара с таким артикулом - нет");
        }

        String query = "UPDATE PRODUCTS SET NAME = ?, ARTICLE = ?, PRICE = ? " +
                "WHERE ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getProductCode());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setInt(4, productToChange.getId());
            preparedStatement.execute();

            return findProduct(product.getProductCode());
        }
    }

    @Override
    public void deleteProduct(String productCode) throws SQLException {
        String deleteProductQuery = "DELETE FROM PRODUCTS WHERE ARTICLE = ?";
        String deleterOrdersQuery = "DELETE FROM ORDERS WHERE PRODUCT_ID = ?";
        try(PreparedStatement statementProduct = connection.prepareStatement(deleteProductQuery);
        PreparedStatement statementOrder = connection.prepareStatement(deleterOrdersQuery))
        {
            statementOrder.setInt(1, findProduct(productCode).getId());
            statementOrder.execute();
            statementProduct.setString(1, productCode);
            statementProduct.execute();
        }
    }
}
