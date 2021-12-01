package ru.croc.task18.DAO_interfaces;

import ru.croc.task18.entities.Order;
import ru.croc.task18.entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {

    Order createOrder(String userLogin, List<Product> products) throws SQLException;

}
