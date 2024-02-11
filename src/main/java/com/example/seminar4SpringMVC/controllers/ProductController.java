package com.example.seminar4SpringMVC.controllers;

import com.example.seminar4SpringMVC.model.Product;
import com.example.seminar4SpringMVC.sevice.ProductService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class ProductController {
    private final ProductService productService;

    // Добавил конструктор, т.к @ALLArgsConstructor не работает......
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProductS(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product p, Model model){
        productService.addProduct(p);
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
}
