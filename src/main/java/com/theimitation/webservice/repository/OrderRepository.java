package com.theimitation.webservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.theimitation.webservice.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}