package ru.croc.task18.entities;

import java.util.Objects;

public class Product {
    private int id;

    private String productCode;

    private String name;

    private int price;

    public Product(int id, String productCode, String name, int price) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public Product(String productCode, String name, int price) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
    }


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return price == product.price && productCode.equals(product.productCode) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, name, price);
    }
}
