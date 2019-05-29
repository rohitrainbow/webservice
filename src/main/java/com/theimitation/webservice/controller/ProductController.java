package com.theimitation.webservice.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theimitation.webservice.model.ProdDescr;
import com.theimitation.webservice.model.Product;
import com.theimitation.webservice.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
    @RequestMapping("/api/products")
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
    
    @RequestMapping("/api/product/{id}")
    public Product getProductDescr(@PathVariable Long id) {
    	System.out.println(id);
    	Product product= productService.getProduct(id);
    	product.setProdDescr(productService.getProductDescr(id));
    	return product;
    }
}