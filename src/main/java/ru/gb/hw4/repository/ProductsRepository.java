package ru.gb.hw4.repository;

import org.springframework.stereotype.Component;
import ru.gb.hw4.entites.Product;

import java.util.ArrayList;

@Component
public class ProductsRepository {
    private ArrayList<Product> products;

    public ProductsRepository() {
        products = new ArrayList<>();
        products.add(new Product(0, "Хлеб", 35));
        products.add(new Product(1, "Колбаса", 400));
        products.add(new Product(2, "Водка", 350));
    }

    public Product getProductsById(int id) {
        return products.get(id);
    }

    public void addProducts(Product product) {
        product.setId(getSizeProductList());
        products.add(product);
    }

    public int getSizeProductList() {
        return products.size();
    }
}