package com.yeti.repository;

import org.springframework.data.repository.CrudRepository;

import com.yeti.model.Users;

public interface UsersRepository extends CrudRepository<Users, Long>{

}