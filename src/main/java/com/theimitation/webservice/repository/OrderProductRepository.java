package com.theimitation.webservice.repository;

import com.theimitation.webservice.model.OrderProduct;
import com.theimitation.webservice.model.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}