package com.theimitation.webservice.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theimitation.webservice.dto.ProdDescrDto;
import com.theimitation.webservice.dto.ProductDto;
import com.theimitation.webservice.model.Product;
import com.theimitation.webservice.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	ProductDto productDto;
	
	@Autowired
	ProdDescrDto prodDescrDto;

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
    @RequestMapping("/api/products")
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
    
    @RequestMapping(method = RequestMethod.POST, value ="/api/product/{id}")
    public ProductDto getProductDescr(@PathVariable Long id) {
    	return productService.getProductDetails(id);
    }
}