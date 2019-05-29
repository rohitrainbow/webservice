package com.theimitation.webservice.service;

import org.springframework.validation.annotation.Validated;

import com.theimitation.webservice.model.ProdDescr;
import com.theimitation.webservice.model.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

	@NotNull
	Iterable<Product> getAllProducts();

	Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);
	
	ProdDescr getProductDescr(Long id);

	Product save(Product product);
	public Product getUsingProductName(String name);
}