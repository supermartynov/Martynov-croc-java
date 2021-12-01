package ru.croc.task18.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private String clientLogin; //в бд login

    public List<Product> products = new ArrayList<>();

    public Order() {
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        String products = "";
        for (Product product : this.products) {
            products += product.getProductCode() + " ";
        }
        return clientLogin + ": " + products ;
    }

}
