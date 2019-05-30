package com.theimitation.webservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theimitation.webservice.dto.ProdDescrDto;
import com.theimitation.webservice.dto.ProductDto;
import com.theimitation.webservice.exception.ResourceNotFoundException;
import com.theimitation.webservice.model.ProdDescr;
import com.theimitation.webservice.model.Product;
import com.theimitation.webservice.repository.ProdDescrRepository;
import com.theimitation.webservice.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	ProductDto productDto;
	
	@Autowired
	ProdDescrDto prodDescrDto;


	private ProductRepository productRepository;
	
	@Autowired
	private ProdDescrRepository prodDescrRepository;
	
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
	public ProdDescr getProductDescr(Long id) {
		return prodDescrRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Descr not found"));
	}
	
	@Override
	public ProductDto getProductDetails(Long id) {
		Product product=new Product();
		ProdDescr prodDescr=new ProdDescr();
		product=getProduct(id);
		product.setProdDescr(getProductDescr(id));
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPictureUrl(product.getPictureUrl());
		productDto.setPrice(product.getPrice());
		prodDescr=getProductDescr(id);
		prodDescrDto.setDescr(prodDescr.getDescr());
		prodDescrDto.setDescrId(prodDescr.getDescrId());
		prodDescrDto.setProductId(prodDescr.getProductId());
		productDto.setProdDescr(prodDescrDto);
		return productDto;
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