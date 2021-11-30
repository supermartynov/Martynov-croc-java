package ru.croc.task18;

import java.util.List;

public interface OrderDAO {

    Order createOrder(String userLogin, List<Product> products);

}
