package ru.gb.hw4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw4.entites.Product;
import ru.gb.hw4.entites.Products;
import ru.gb.hw4.service.ProductService;

import java.util.Arrays;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        Product[] products = new Product[productService.getSizeProductsList()];
        for (int i = 0; i < productService.getSizeProductsList(); i++) {
            products[i] = productService.getProductById(i);
        }
        Products listProducts = new Products();
        listProducts.setProducts(products);
        model.addAttribute("products", listProducts);
        System.out.println(Arrays.toString(products));
        return "products";
    }
/*
    @RequestMapping(path = "/byid", method = RequestMethod.GET)
    public Product productById(Model model, @RequestParam int id) {
        Product product = productService.getProductById(id);
        return product;
    }

    @RequestMapping("/showForm")
    public String showSimpleForm(Model model) {
        Product product = new Product();
        product.setId(-1);
        product.setTitle("");
        product.setCost(0);
        model.addAttribute("product", product);
        return "productform";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        productService.addProductToRepository(product);
        product.setId(productService.getSizeProductsList());
        return "formresult";
    }
*/
}


