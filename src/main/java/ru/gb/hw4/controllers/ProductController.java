package ru.gb.hw4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw4.entites.Product;
import ru.gb.hw4.service.ProductService;


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
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping(path = "/byid")
    public String productById(Model model, @RequestParam int id) {
        Product product = productService.getProductById(id);
        model.addAttribute("result",product);
        return "byid";
    }

    @GetMapping("/showForm")
    public String showSimpleForm(Model model) {
        Product product = new Product();
        product.setId(-1);
        product.setTitle("");
        product.setCost(0);
        model.addAttribute("product", product);
        return "productform";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute Product product,Model model) {
        productService.addProductToRepository(product);
        model.addAttribute("product",product);
        return "formresult";
    }

}


