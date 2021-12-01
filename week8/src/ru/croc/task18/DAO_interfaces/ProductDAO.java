package ru.croc.task18.DAO_interfaces;

import ru.croc.task18.entities.Product;

import java.sql.SQLException;

public interface ProductDAO {
    Product findProduct(String productCode) throws SQLException;

    Product createProduct(Product product) throws SQLException;

    Product updateProduct(Product product) throws SQLException;

    void deleteProduct(String productCode) throws SQLException;
}
