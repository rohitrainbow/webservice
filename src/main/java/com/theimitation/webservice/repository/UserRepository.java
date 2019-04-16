package com.theimitation.webservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.theimitation.webservice.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
