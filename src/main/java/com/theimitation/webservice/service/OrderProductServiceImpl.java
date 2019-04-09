package com.theimitation.webservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.theimitation.webservice.repository.OrderProductRepository;
import com.theimitation.webservice.model.OrderProduct;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

	private OrderProductRepository orderProductRepository;

	public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
		this.orderProductRepository = orderProductRepository;
	}

	@Override
	public OrderProduct create(OrderProduct orderProduct) {
		return this.orderProductRepository.save(orderProduct);
	}
}