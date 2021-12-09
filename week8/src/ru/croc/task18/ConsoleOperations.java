package ru.croc.task18;

import ru.croc.task18.DAO_implementations.OrderDAOImplementation;
import ru.croc.task18.DAO_implementations.ProductDAOImplementation;
import ru.croc.task18.entities.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ConsoleOperations implements AutoCloseable{
    private ProductDAOImplementation productDAOImplementation = new ProductDAOImplementation();

    private OrderDAOImplementation orderDAOImplementation = new OrderDAOImplementation();

    public void createProduct(String[] strings) throws SQLException {
        productDAOImplementation.createProduct(returnProductFromStringArray(strings));
    }

    public void changeProduct(String[] strings) throws SQLException {
        productDAOImplementation.updateProduct(returnProductFromStringArray(strings));
    }

    public void deleteProduct(String[] strings) throws SQLException {
        productDAOImplementation.deleteProduct(strings[1]);
    }

    public void order(String[] strings) throws SQLException {
        String login = strings[1];
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 2; i < strings.length; i++) {
            products.add(productDAOImplementation.findProduct(strings[i]));
        }
        orderDAOImplementation.createOrder(login, products);
    }

    private Product returnProductFromStringArray(String[] strings) {
        String productCode = strings[1];
        String name = strings[2];
        int price = Integer.parseInt(strings[3]);
        return new Product(productCode, name, price);
    }

    @Override
    public void close() throws Exception {
        orderDAOImplementation.connection.close();
        productDAOImplementation.connection.close();
    }
}
