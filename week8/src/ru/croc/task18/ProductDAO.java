package ru.croc.task18;

public interface ProductDAO {
    Product findProduct(String productCode);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(String productCode);
}
