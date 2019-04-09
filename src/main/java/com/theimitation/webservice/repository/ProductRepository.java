package com.theimitation.webservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.theimitation.webservice.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}