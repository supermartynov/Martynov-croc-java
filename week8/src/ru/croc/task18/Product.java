package ru.croc.task18;

public class Product {
    private String productCode; //в бд это article

    private String name;

    private int price;

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
}
