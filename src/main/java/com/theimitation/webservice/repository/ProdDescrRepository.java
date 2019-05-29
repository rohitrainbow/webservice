package com.theimitation.webservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.theimitation.webservice.model.ProdDescr;

@Repository
public interface ProdDescrRepository extends CrudRepository<ProdDescr, Long> {
}