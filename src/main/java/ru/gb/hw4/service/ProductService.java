package ru.gb.hw4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.hw4.entites.Product;
import ru.gb.hw4.repository.ProductsRepository;

@Component
public class ProductService {
    ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product getProductById(int id) {
        return productsRepository.getProductsById(id);
    }

    public void addProductToRepository(Product product) {
        productsRepository.addProducts(product);
    }

    public int getSizeProductsList() {
        return productsRepository.getSizeProductList();
    }

}