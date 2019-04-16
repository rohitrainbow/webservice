package com.theimitation.webservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theimitation.webservice.exception.ResourceNotFoundException;
import com.theimitation.webservice.model.Product;
import com.theimitation.webservice.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	EntityManager entityManager;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Product getUsingProductName(String name)
	{
		List<Product> results=new ArrayList<Product>();
		results = entityManager.createQuery("SELECT a FROM Product a where a.name = :articleNo")
                .setParameter("articleNo", name).getResultList();
		return results.get(0);
	}
}