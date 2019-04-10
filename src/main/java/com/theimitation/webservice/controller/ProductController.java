package com.theimitation.webservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theimitation.webservice.model.Product;
import com.theimitation.webservice.service.ProductService;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://20.198.10.4:8086")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
}